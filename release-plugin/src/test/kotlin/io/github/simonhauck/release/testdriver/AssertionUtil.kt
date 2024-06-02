package io.github.simonhauck.release.testdriver

import arrow.core.Either
import io.github.simonhauck.release.git.api.GitError
import io.github.simonhauck.release.git.api.isOk
import org.assertj.core.api.Assertions.assertThat

internal fun <T> Either<GitError, T>.assertIsOk(): T {
    assertThat(isOk()).withFailMessage { "Command is not ok failed:\n$this" }.isTrue()
    return get()
}

internal fun <T, E> Either<T, E>.get(): E {
    return when (this) {
        is Either.Left -> throw IllegalStateException("Expected Right but got Left")
        is Either.Right -> this.value
    }
}
