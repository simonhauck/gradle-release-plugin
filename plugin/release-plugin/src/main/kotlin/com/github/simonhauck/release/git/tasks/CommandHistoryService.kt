package com.github.simonhauck.release.git.tasks

import arrow.core.Either
import com.github.simonhauck.release.git.wrapper.GitError
import java.util.*
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

data class RevertCommand(val message: String, val revertCommand: () -> Either<GitError, *>)

interface CommandHistoryApi {
    fun registerRevertCommand(command: RevertCommand)

    fun flushCommands()

    fun revertAllCommands()
}

internal abstract class CommandHistoryService :
    BuildService<BuildServiceParameters.None>, CommandHistoryApi {
    private val commandStack = Stack<RevertCommand>()

    override fun registerRevertCommand(command: RevertCommand) {
        commandStack.push(command)
    }

    override fun flushCommands() {
        commandStack.clear()
    }

    override fun revertAllCommands() {
        println("Reverting changes... (size=${commandStack.size})")
        while (commandStack.isNotEmpty()) {
            val lastCommand = commandStack.pop()

            print("${lastCommand.message}...")
            val status = lastCommand.revertCommand()
            val resultMessage = if (status.isLeft()) "FAILED" else "OK"
            println(" $resultMessage")
        }
        println("Changes reverted.")
    }
}
