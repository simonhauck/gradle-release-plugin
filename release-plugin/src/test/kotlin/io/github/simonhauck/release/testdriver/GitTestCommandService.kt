package io.github.simonhauck.release.testdriver

import io.github.simonhauck.release.git.api.GitError
import io.github.simonhauck.release.git.api.GitOk
import io.github.simonhauck.release.git.api.GitVoidResult
import io.github.simonhauck.release.git.internal.commands.GitCommandProcessWrapper
import io.github.simonhauck.release.util.Either
import io.github.simonhauck.release.util.flatten
import io.github.simonhauck.release.util.map
import java.io.File

internal class GitTestCommandService(
    workDir: File,
    sshKeyFile: File? = null,
    disableStrictHostKeyChecking: Boolean = false,
) : GitCommandProcessWrapper(workDir, null, sshKeyFile, disableStrictHostKeyChecking) {

    fun initBareRepository(): GitVoidResult {
        return gitVoidCommand(listOf("init", "--bare"))
    }

    fun clone(repositoryUrl: String, directoryName: String, branchName: String): GitVoidResult {
        return gitVoidCommand(listOf("clone", repositoryUrl, directoryName, "-b", branchName))
    }

    fun clone(repositoryUrl: String, directoryName: String): GitVoidResult {
        return gitVoidCommand(listOf("clone", repositoryUrl, directoryName))
    }


    fun checkOutTag(tagName: String): GitVoidResult {
        return gitVoidCommand(listOf("checkout", tagName))
    }

    fun configureNameAndEmailLocally(name: String, email: String): Either<GitError, GitOk> {
        return gitVoidCommand(listOf("config", "user.name", name))
            .map { gitVoidCommand(listOf("config", "user.email", email)) }
            .flatten()
    }
}
