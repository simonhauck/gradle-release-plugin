package com.github.simonhauck.git.wrapper

interface GitCommandApi {
    fun gitInit(branchName: String): GitVoidResult

    fun gitStatus(): GitVoidResult

    fun createBranch(branchName: String): GitVoidResult

    fun gitAdd(filePattern: String): GitVoidResult

    fun gitCommit(message: String): GitVoidResult

    fun gitLog(): GitResult<List<GitLogEntry>>

    fun getLocalBranchNames(): GitResult<List<String>>
}
