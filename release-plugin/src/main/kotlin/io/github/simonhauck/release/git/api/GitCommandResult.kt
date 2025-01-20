package io.github.simonhauck.release.git.api

import io.github.simonhauck.release.util.Either
import org.gradle.api.GradleException

typealias GitVoidResult = Either<GitError, GitOk>

typealias GitResult<T> = Either<GitError, T>

object GitOk

data class GitError(val message: String, val throwable: Throwable? = null)

data class GitLogEntry(
    val hash: String,
    val message: String,
    val authorName: String,
    val authorEmail: String,
    val commiterName: String,
    val commiterEmail: String,
)

data class GitStatusResult(
    val staged: List<String>,
    val unstaged: List<String>,
    val untracked: List<String>,
) {
    fun allEmpty() = staged.isEmpty() && unstaged.isEmpty() && untracked.isEmpty()

    fun notEmpty() = !allEmpty()
}

internal fun Either<GitError, *>.isOk(): Boolean = isRight()

internal fun <T> GitResult<T>.getOrThrowGradleException(): T {
    return when (this) {
        is Either.Left -> throw GradleException(this.value.message, this.value.throwable)
        is Either.Right -> this.value
    }
}
