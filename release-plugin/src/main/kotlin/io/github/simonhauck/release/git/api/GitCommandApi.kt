package io.github.simonhauck.release.git.api

import io.github.simonhauck.release.git.internal.commands.GitCommandProcessWrapper
import java.io.File

interface GitCommandApi {
    fun init(branchName: String): GitVoidResult

    fun status(): GitResult<GitStatusResult>

    fun createBranch(branchName: String): GitVoidResult

    fun deleteBranch(branchName: String): GitVoidResult

    fun add(filePattern: String): GitVoidResult

    fun reset(filePattern: String): GitVoidResult

    fun commit(message: String): GitVoidResult

    fun addRemoteAndSetUpstream(
        remoteName: String,
        remoteUrl: String,
        branchName: String
    ): GitVoidResult

    fun push(): GitVoidResult

    fun deleteLastCommit(): GitVoidResult

    fun log(): GitResult<List<GitLogEntry>>

    fun stash(includeUntracked: Boolean): GitVoidResult

    fun stashPop(): GitVoidResult

    fun getLocalBranchNames(): GitResult<List<String>>

    fun tag(tagName: String, tagMessage: String): GitVoidResult

    fun listTags(): GitResult<List<String>>

    fun deleteLocalTag(tagName: String): GitVoidResult

    fun pullRebase(): GitVoidResult

    companion object {
        fun create(
            gitRootDirectory: File? = null,
            user: GitUser? = null,
            sshKeyFile: File? = null,
        ): GitCommandApi {
            return GitCommandProcessWrapper(gitRootDirectory, user, sshKeyFile)
        }
    }
}

data class GitUser(val name: String, val email: String)
