package io.github.simonhauck.release.git.internal.commands

import io.github.simonhauck.release.git.api.GitCommandHistoryApi
import io.github.simonhauck.release.git.api.RevertCommand
import java.util.*
import org.gradle.api.logging.Logging
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

internal abstract class GitCommandHistoryService :
    BuildService<BuildServiceParameters.None>, GitCommandHistoryApi {

    private val log = Logging.getLogger(GitCommandHistoryService::class.java)

    private val commandStack = Stack<RevertCommand>()

    override fun registerRevertCommand(command: RevertCommand) {
        commandStack.push(command)
    }

    override fun flushCommands() {
        commandStack.clear()
    }

    override fun revertAllCommands() {
        log.lifecycle(
            "Trying to revert changes that are already done... (size=${commandStack.size})"
        )
        while (commandStack.isNotEmpty()) {
            val lastCommand = commandStack.pop()

            log.lifecycle("${lastCommand.message}...")
            val status = lastCommand.revertCommand()
            val resultMessage = if (status.isLeft()) "FAILED" else "OK"
            log.lifecycle("- $resultMessage")
        }
        log.lifecycle("Changes reverted.")
    }
}
