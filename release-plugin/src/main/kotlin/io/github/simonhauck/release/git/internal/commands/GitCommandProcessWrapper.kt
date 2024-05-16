package io.github.simonhauck.release.git.internal.commands

import arrow.core.Either
import arrow.core.flatten
import io.github.simonhauck.release.git.api.*
import io.github.simonhauck.release.git.internal.process.ProcessConfig
import io.github.simonhauck.release.git.internal.process.ProcessSuccess
import io.github.simonhauck.release.git.internal.process.ProcessWrapper

internal class GitCommandProcessWrapper(
    private val processWrapper: ProcessWrapper = ProcessWrapper(),
    private val config: ProcessConfig = ProcessConfig()
) : GitCommandApi {

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
        return gitVoidCommand(listOf("reset", "--hard", "HEAD~1"))
    }

    override fun push(): GitVoidResult {
        return gitVoidCommand(listOf("push"))
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
            processSuccess.output.map { line ->
                val split = line.split(" ")
                GitLogEntry(split[0], split.drop(1).joinToString(" "))
            }
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

    private fun gitCommand(command: List<String>): Either<GitError, ProcessSuccess> {
        val runCommand = processWrapper.runCommand(listOf("git").plus(command), config)
        return runCommand.mapLeft { GitError(it.message, it.error) }
    }
}
