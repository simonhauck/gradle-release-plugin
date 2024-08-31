package io.github.simonhauck.release.git.internal.process

import arrow.core.Either
import arrow.core.flatten
import arrow.core.raise.either
import arrow.core.raise.ensure
import java.util.concurrent.TimeUnit
import org.gradle.api.logging.Logging
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import org.zeroturnaround.exec.ProcessExecutor
import org.zeroturnaround.exec.stream.LogOutputStream

internal class ProcessWrapper {
    private val log = Logging.getLogger(ProcessWrapper::class.java)

    fun runCommand(command: List<String>, config: ProcessConfig = ProcessConfig()): ProcessResult =
        Either.catch { runCommandOrThrow(config, command) }
            .mapLeft { ProcessError(null, emptyList(), it, "Command failed with an exception") }
            .flatten()

    private fun runCommandOrThrow(config: ProcessConfig, command: List<String>): ProcessResult =
        either {
            val processOutputCaptor: MutableList<String> = mutableListOf()
            val result =
                ProcessExecutor()
                    .directory(config.workingDir)
                    .environment(config.environment)
                    .addOsSpecificCommands(*command.toTypedArray())
                    .handleConsoleOutput(processOutputCaptor)
                    .destroyWithDescendants()
                    .timeout(40, TimeUnit.SECONDS)
                    .execute()

            ensure(result.exitValue == 0) {
                raise(
                    ProcessError(
                        result.exitValue,
                        processOutputCaptor,
                        error = null,
                        message =
                            "Command finished with non zero exit code (code=${result.exitValue})",
                    )
                )
            }

            ProcessSuccess(exitCode = result.exitValue, output = processOutputCaptor)
        }

    private fun ProcessExecutor.addOsSpecificCommands(vararg command: String): ProcessExecutor {
        val linuxCommand = listOf(*command)
        val windowsCommand = listOf("cmd.exe", "/c", *command)

        val commandToExecute =
            if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) windowsCommand
            else linuxCommand

        return this.command(commandToExecute)
    }

    private fun ProcessExecutor.handleConsoleOutput(
        outputCaptor: MutableList<String>
    ): ProcessExecutor {
        return this.redirectOutput(ProcessOutputHandler(false, outputCaptor))
            .redirectError(ProcessOutputHandler(true, outputCaptor))
    }

    private fun ProcessExecutor.destroyWithDescendants(): ProcessExecutor {
        return this.destroyOnExit().stopper { it.destroyWithDescendants() }
    }

    private fun Process.destroyWithDescendants() {
        log.debug("Killing process children...")
        this.descendants().forEach { childProcess -> childProcess.destroy() }
        log.debug("Killing process...")
        this.destroy()
        log.debug("Waiting for shutdown (30 sec max)...")
        this.waitFor(30, TimeUnit.SECONDS)
        log.debug("Process is terminated")
    }

    private class ProcessOutputHandler(
        private val isError: Boolean,
        private val outputCaptor: MutableList<String>,
    ) : LogOutputStream() {
        private val log = Logging.getLogger(ProcessOutputHandler::class.java)

        override fun processLine(line: String) {

            outputCaptor.add(line)
            if (isError) log.info("StdErr: $line") else log.info("StdOut: $line")
        }
    }
}
