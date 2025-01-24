package io.github.simonhauck.release.git.api

import io.github.simonhauck.release.util.Either

interface GitCommandHistoryApi {
    fun registerRevertCommand(command: RevertCommand)

    fun flushCommands()

    fun revertAllCommands()

    fun dropLastRevertCommand()
}

data class RevertCommand(val message: String, val revertCommand: () -> Either<GitError, *>)
