package io.github.simonhauck.release.tasks

import arrow.core.Either
import io.github.simonhauck.release.git.api.*
import java.io.File
import org.gradle.api.GradleException
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

    fun <T> GitResult<T>.getOrThrowGradleException(): T {
        return when (this) {
            is Either.Left -> throw GradleException(this.value.message, this.value.throwable)
            is Either.Right -> this.value
        }
    }
}
