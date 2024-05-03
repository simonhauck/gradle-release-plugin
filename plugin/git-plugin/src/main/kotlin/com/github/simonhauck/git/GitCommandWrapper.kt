package com.github.simonhauck.git

import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.process.ProcessResult
import com.github.simonhauck.git.process.ProcessWrapper

internal class GitCommandWrapper(
    private val processWrapper: ProcessWrapper = ProcessWrapper(),
    private val config: ProcessConfig = ProcessConfig()
) {

    fun gitInit(): ProcessResult {
        return processWrapper.runCommand(listOf("git", "init"), config)
    }

    fun gitStatus(): ProcessResult {
        return processWrapper.runCommand(listOf("git", "status"), config)
    }
}
