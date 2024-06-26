package io.github.simonhauck.release.tasks

import arrow.core.Either
import io.github.simonhauck.release.git.api.GitError
import org.gradle.api.GradleException

internal fun <T> Either<GitError, T>.getOrThrowGradleException(): T {
    return when (this) {
        is Either.Left -> throw GradleException(this.value.message, this.value.throwable)
        is Either.Right -> this.value
    }
}
