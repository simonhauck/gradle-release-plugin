package io.github.simonhauck.release.git.internal.commands

import arrow.core.Either
import arrow.core.flatten
import arrow.core.getOrElse
import io.github.simonhauck.release.git.api.*
import io.github.simonhauck.release.git.internal.process.ProcessConfig
import io.github.simonhauck.release.git.internal.process.ProcessSuccess
import io.github.simonhauck.release.git.internal.process.ProcessWrapper
import io.github.simonhauck.release.git.internal.process.exitCode
import io.github.simonhauck.release.tasks.PushTask
import java.io.File
import org.gradle.api.logging.Logging

internal class GitCommandProcessWrapper(
    private val processWrapper: ProcessWrapper = ProcessWrapper(),
    private val config: ProcessConfig = ProcessConfig()
) : GitCommandApi {

    private val log = Logging.getLogger(PushTask::class.java)

    override fun init(branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("init", "--initial-branch=$branchName"))
    }

    override fun status(): GitResult<GitStatusResult> {
        return gitCommand(listOf("status", "--porcelain")).map { processSuccess ->
            val lines = processSuccess.output
            val staged = mutableListOf<String>()
            val unstaged = mutableListOf<String>()
            val untracked = mutableListOf<String>()

            lines.forEach { line ->
                when {
                    line.startsWith("??") -> untracked.add(line.drop(3))
                    line.startsWith(" ") -> unstaged.add(line.drop(3))
                    else -> staged.add(line.drop(3))
                }
            }

            GitStatusResult(staged, unstaged, untracked)
        }
    }

    override fun add(filePattern: String): GitVoidResult {
        return gitVoidCommand(listOf("add", filePattern))
    }

    override fun reset(filePattern: String): GitVoidResult {
        return gitVoidCommand(listOf("reset", filePattern))
    }

    override fun commit(message: String): GitVoidResult {
        return gitVoidCommand(listOf("commit", "-m", message))
    }

    override fun deleteLastCommit(): GitVoidResult {
        val stashChangedFiles = status().map { it.notEmpty() }.getOrElse { false }
        if (stashChangedFiles) gitVoidCommand(listOf("stash", "--include-untracked"))

        val result = gitVoidCommand(listOf("reset", "--hard", "HEAD~1"))

        if (stashChangedFiles) gitVoidCommand(listOf("stash", "pop"))

        return result
    }

    // TODO Simon.Hauck 2024-05-17 - How to test the git push behavior with credentials?
    override fun push(sshKeyFile: File?): GitVoidResult {
        val envToAdd =
            if (sshKeyFile != null)
                mapOf(
                    "GIT_SSH_VARIANT" to "ssh",
                    "GIT_SSH_COMMAND" to "ssh -i ${sshKeyFile.absolutePath} -o IdentitiesOnly=yes"
                )
            else emptyMap()

        val pushConfig = config.copy(environment = config.environment.plus(envToAdd))

        return gitVoidCommand(listOf("push", "--follow-tags"), pushConfig)
    }

    override fun pullRebase(): GitVoidResult {
        return gitVoidCommand(listOf("pull", "--rebase"))
    }

    override fun addRemoteAndSetUpstream(
        remoteName: String,
        remoteUrl: String,
        branchName: String
    ): GitVoidResult {
        return gitVoidCommand(listOf("remote", "add", remoteName, remoteUrl))
            .map { gitVoidCommand(listOf("push", "-u", remoteName, branchName)) }
            .flatten()
    }

    override fun log(): GitResult<List<GitLogEntry>> {
        return gitCommand(listOf("log", "--pretty=oneline")).map { processSuccess ->
            processSuccess.output
                .map { line ->
                    val split = line.split(" ")
                    GitLogEntry(split[0], split.drop(1).joinToString(" "))
                }
                .asReversed()
        }
    }

    override fun createBranch(branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("branch", branchName))
    }

    override fun deleteBranch(branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("branch", "-D", branchName))
    }

    override fun getLocalBranchNames(): GitResult<List<String>> {
        return gitCommand(listOf("--no-pager", "branch")).map { processSuccess ->
            processSuccess.output.map { it.trim() }
        }
    }

    override fun tag(tagName: String, tagMessage: String): GitVoidResult {
        return gitVoidCommand(listOf("tag", "-a", tagName, "-m", tagMessage))
    }

    override fun deleteLocalTag(tagName: String): GitVoidResult {
        return gitVoidCommand(listOf("tag", "-d", tagName))
    }

    override fun listTags(): GitResult<List<String>> {
        return gitCommand(listOf("tag")).map { processSuccess ->
            processSuccess.output.map { it.trim() }
        }
    }

    private fun gitVoidCommand(
        command: List<String>,
        processConfig: ProcessConfig? = null
    ): Either<GitError, GitOk> {
        val runCommand = gitCommand(command, processConfig)
        return runCommand.map { GitOk }
    }

    private fun gitCommand(
        command: List<String>,
        processConfig: ProcessConfig? = null
    ): Either<GitError, ProcessSuccess> {
        val gitCommand = listOf("git").plus(command)
        log.info("Running git command: '${gitCommand.joinToString(" ")}'")

        val runCommand = processWrapper.runCommand(gitCommand, processConfig ?: config)
        log.info("Command finished (exitCode=${runCommand.exitCode()})")

        val commandString = command.joinToString(" ")
        return runCommand
            .onLeft {
                log.error("Failed to execute command '$commandString'. Error: ${it.message}")
            }
            .mapLeft {
                val output =
                    listOf(
                            "Failed to execute command: '$commandString'",
                            it.message,
                            "--- Git output ---"
                        )
                        .plus(it.output)
                        .plus("--- End of output ---")
                        .joinToString("\n")

                GitError(output, it.error)
            }
    }
}
