package com.github.simonhauck.release.testdriver

import arrow.core.Either
import com.github.simonhauck.release.git.api.GitError
import com.github.simonhauck.release.git.api.isOk
import org.assertj.core.api.Assertions

fun <T> Either<GitError, T>.assertIsOk(): T {
    Assertions.assertThat(isOk()).isTrue()
    return get()
}

fun <T, E> Either<T, E>.get(): E {
    return when (this) {
        is Either.Left -> throw IllegalStateException("Expected Right but got Left")
        is Either.Right -> this.value
    }
}
