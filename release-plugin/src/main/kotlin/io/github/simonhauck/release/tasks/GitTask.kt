package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.git.api.GitCommandHistoryApi
import io.github.simonhauck.release.git.api.GitError
import io.github.simonhauck.release.git.api.GitResult
import io.github.simonhauck.release.git.api.GitUser
import io.github.simonhauck.release.git.api.RevertCommand
import io.github.simonhauck.release.util.Either
import io.github.simonhauck.release.util.onLeft
import io.github.simonhauck.release.util.onRight
import java.io.File
import org.gradle.api.Task
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional

interface GitTask : Task {

    @get:Input val gitRootDirectory: Property<File>
    @get:InputFile @get:Optional val sshKeyFile: RegularFileProperty
    @get:Input @get:Optional val gitName: Property<String>
    @get:Input @get:Optional val gitEmail: Property<String>

    @get:Internal val gitCommandHistoryApi: Property<GitCommandHistoryApi>

    fun gitCommandApi(): GitCommandApi {
        val userName = gitName.orNull
        val email = gitEmail.orNull
        val user = if (userName != null && email != null) GitUser(userName, email) else null
        return GitCommandApi.create(gitRootDirectory.get(), user, sshKeyFile.asFile.orNull)
    }

    fun <T> GitResult<T>.revertHistoryOnError(): Either<GitError, T> {
        return onLeft { gitCommandHistoryApi.get().revertAllCommands() }
    }

    fun <T> GitResult<T>.registerRevertCommandOnSuccess(
        revertCommand: RevertCommand
    ): Either<GitError, T> {
        return onRight { gitCommandHistoryApi.get().registerRevertCommand(revertCommand) }
    }
}
