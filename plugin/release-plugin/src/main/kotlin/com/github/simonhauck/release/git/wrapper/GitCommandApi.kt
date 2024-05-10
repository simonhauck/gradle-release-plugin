package com.github.simonhauck.release.git.wrapper

import com.github.simonhauck.release.git.process.ProcessConfig
import java.io.File

interface GitCommandApi {
    fun init(branchName: String): GitVoidResult

    fun status(): GitResult<GitStatusResult>

    fun createBranch(branchName: String): GitVoidResult

    fun deleteBranch(branchName: String): GitVoidResult

    fun add(filePattern: String): GitVoidResult

    fun reset(filePattern: String): GitVoidResult

    fun commit(message: String): GitVoidResult

    fun deleteLastCommit(): GitVoidResult

    fun log(): GitResult<List<GitLogEntry>>

    fun getLocalBranchNames(): GitResult<List<String>>

    fun tag(tagName: String, tagMessage: String): GitVoidResult

    fun listTags(): GitResult<List<String>>

    fun deleteLocalTag(tagName: String): GitVoidResult

    companion object {
        fun create(gitRootDirectory: File): GitCommandApi =
            GitCommandProcessWrapper(config = ProcessConfig(workingDir = gitRootDirectory))
    }
}
