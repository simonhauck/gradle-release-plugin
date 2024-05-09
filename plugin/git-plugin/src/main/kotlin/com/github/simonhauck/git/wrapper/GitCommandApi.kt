package com.github.simonhauck.git.wrapper

import com.github.simonhauck.git.process.ProcessConfig
import java.io.File

interface GitCommandApi {
    fun gitInit(branchName: String): GitVoidResult

    fun gitStatus(): GitVoidResult

    fun createBranch(branchName: String): GitVoidResult

    fun deleteBranch(branchName: String): GitVoidResult

    fun gitAdd(filePattern: String): GitVoidResult

    fun gitCommit(message: String): GitVoidResult

    fun gitLog(): GitResult<List<GitLogEntry>>

    fun getLocalBranchNames(): GitResult<List<String>>

    companion object {
        fun create(gitRootDirectory: File): GitCommandApi =
            GitCommandProcessWrapper(config = ProcessConfig(workingDir = gitRootDirectory))
    }
}
