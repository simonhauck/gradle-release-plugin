package com.github.simonhauck.git.wrapper

import arrow.core.Either
import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.process.ProcessSuccess
import com.github.simonhauck.git.process.ProcessWrapper

internal class GitCommandProcessWrapper(
    private val processWrapper: ProcessWrapper = ProcessWrapper(),
    private val config: ProcessConfig = ProcessConfig()
) : GitCommandApi {

    override fun gitInit(branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("init", "--initial-branch=$branchName"))
    }

    override fun gitStatus(): GitVoidResult {
        return gitVoidCommand(listOf("status"))
    }

    override fun gitAdd(filePattern: String): GitVoidResult {
        return gitVoidCommand(listOf("add", filePattern))
    }

    override fun gitCommit(message: String): GitVoidResult {
        return gitVoidCommand(listOf("commit", "-m", message))
    }

    override fun gitLog(): GitResult<List<GitLogEntry>> {
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

    private fun gitVoidCommand(command: List<String>): Either<GitError, GitOk> {
        val runCommand = gitCommand(command)
        return runCommand.map { GitOk }
    }

    private fun gitCommand(command: List<String>): Either<GitError, ProcessSuccess> {
        val runCommand = processWrapper.runCommand(listOf("git").plus(command), config)
        return runCommand.mapLeft { GitError(it.message, it.error) }
    }
}
