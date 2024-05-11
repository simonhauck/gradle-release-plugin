package io.github.simonhauck.release.git.api

import arrow.core.Either

interface GitCommandHistoryApi {
    fun registerRevertCommand(command: RevertCommand)

    fun flushCommands()

    fun revertAllCommands()
}

data class RevertCommand(
    val message: String,
    val revertCommand: () -> Either<GitError, *>,
)
