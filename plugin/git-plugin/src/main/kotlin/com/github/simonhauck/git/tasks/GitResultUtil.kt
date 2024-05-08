package com.github.simonhauck.git.tasks

import arrow.core.Either
import com.github.simonhauck.git.wrapper.GitError
import org.gradle.api.GradleException

internal fun <T> Either<GitError, T>.getOrThrowGradleException(): T {
    return when (this) {
        is Either.Left -> throw GradleException(this.value.message, this.value.throwable)
        is Either.Right -> this.value
    }
}
