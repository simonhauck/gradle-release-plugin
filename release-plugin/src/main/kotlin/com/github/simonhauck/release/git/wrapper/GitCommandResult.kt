package com.github.simonhauck.release.git.wrapper

import arrow.core.Either

typealias GitVoidResult = Either<GitError, GitOk>

typealias GitResult<T> = Either<GitError, T>

object GitOk

data class GitError(val message: String, val throwable: Throwable? = null)

data class GitLogEntry(
    val hash: String,
    val message: String,
)

data class GitStatusResult(
    val staged: List<String>,
    val unstaged: List<String>,
    val untracked: List<String>
) {
    fun allEmpty() = staged.isEmpty() && unstaged.isEmpty() && untracked.isEmpty()
}

fun Either<GitError, *>.isOk(): Boolean = isRight()