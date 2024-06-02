package io.github.simonhauck.release.git.internal.commands

import arrow.core.Either
import arrow.core.flatten
import arrow.core.getOrElse
import io.github.simonhauck.release.git.api.*
import io.github.simonhauck.release.git.internal.process.*
import io.github.simonhauck.release.tasks.PushTask
import java.io.File
import org.gradle.api.logging.Logging

internal class GitCommandProcessWrapper(
    private val rootGitDirectory: File?,
    private val gitUser: GitUser?,
    // TODO Simon.Hauck 2024-06-02 - How to test authentication
    private val sshKeyFile: File?,
    private val processWrapper: ProcessWrapper = ProcessWrapper()
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

    override fun push(): GitVoidResult {
        return gitVoidCommand(listOf("push", "--follow-tags"))
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

    private fun gitVoidCommand(command: List<String>): Either<GitError, GitOk> {
        val runCommand = gitCommand(command)
        return runCommand.map { GitOk }
    }

    private fun gitCommand(
        command: List<String>,
    ): Either<GitError, ProcessSuccess> {
        val gitCommand = listOf("git").plus(command)
        log.info("Running git command: '${gitCommand.joinToString(" ")}'")

        val processEnvironment = addUserEnvironment(gitUser).plus(sshKeyEnvironment(sshKeyFile))

        val processConfig =
            ProcessConfig(workingDir = rootGitDirectory, environment = processEnvironment)

        val runCommand = processWrapper.runCommand(gitCommand, processConfig)
        log.info("Command finished (exitCode=${runCommand.exitCode()})")

        val commandString = command.joinToString(" ")
        return runCommand
            .onLeft {
                log.error("Failed to execute command '$commandString'. Error: ${it.message}")
            }
            .mapLeft { buildErrorMessageWithConsoleOutput(commandString, it) }
    }

    private fun sshKeyEnvironment(sshKeyFile: File?): Map<String, String> {
        if (sshKeyFile == null) return emptyMap()
        return mapOf(
            "GIT_SSH_VARIANT" to "ssh",
            "GIT_SSH_COMMAND" to "ssh -i ${sshKeyFile.absolutePath} -o IdentitiesOnly=yes"
        )
    }

    private fun addUserEnvironment(gitUser: GitUser?): Map<String, String> {
        if (gitUser == null) return emptyMap()
        return mapOf(
            "GIT_COMMITTER_NAME" to gitUser.name,
            "GIT_AUTHOR_NAME" to gitUser.name,
            "GIT_COMMITTER_EMAIL" to gitUser.email,
            "GIT_AUTHOR_EMAIL" to gitUser.email
        )
    }

    private fun buildErrorMessageWithConsoleOutput(
        commandString: String,
        it: ProcessError
    ): GitError {
        val output =
            listOf("Failed to execute command: '$commandString'", it.message, "--- Git output ---")
                .plus(it.output)
                .plus("--- End of output ---")
                .joinToString("\n")

        return GitError(output, it.error)
    }
}
