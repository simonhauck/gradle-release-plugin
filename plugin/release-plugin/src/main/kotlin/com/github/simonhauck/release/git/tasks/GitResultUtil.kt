package com.github.simonhauck.release.git.tasks

import arrow.core.Either
import com.github.simonhauck.release.git.wrapper.GitError
import org.gradle.api.GradleException

internal fun <T> Either<GitError, T>.getOrThrowGradleException(): T {
    return when (this) {
        is Either.Left -> throw GradleException(this.value.message, this.value.throwable)
        is Either.Right -> this.value
    }
}
