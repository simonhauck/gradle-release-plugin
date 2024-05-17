package io.github.simonhauck.release.testdriver

import arrow.core.Either
import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.git.api.GitError
import io.github.simonhauck.release.git.api.GitOk
import io.github.simonhauck.release.git.api.GitVoidResult
import io.github.simonhauck.release.git.internal.process.ProcessConfig
import io.github.simonhauck.release.git.internal.process.ProcessSuccess
import io.github.simonhauck.release.git.internal.process.ProcessWrapper
import java.io.File

internal class GitTestCommandService(private val workDir: File) :
    GitCommandApi by GitCommandApi.create(workDir) {

    private val config = ProcessConfig(workingDir = workDir)
    private val processWrapper = ProcessWrapper()

    fun initBareRepository(): GitVoidResult {
        return gitVoidCommand(listOf("init", "--bare"))
    }

    fun clone(repositoryUrl: String, directoryName: String, branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("clone", repositoryUrl, directoryName, "-b", branchName))
    }

    fun checkOutTag(tagName: String): GitVoidResult {
        return gitVoidCommand(listOf("checkout", tagName))
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
