package com.github.simonhauck.git

import java.io.File

class GitCommand {

    fun createBranch() {

        ProcessExecutor().command("git", "branch", branchName).execute()
    }
}

data class ProcessConfig(
    val environment: Map<String, String> = emptyMap(),
    val workingDir: File? = null
)
