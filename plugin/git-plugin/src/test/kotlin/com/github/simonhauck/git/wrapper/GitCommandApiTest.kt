package com.github.simonhauck.git.wrapper

import arrow.core.Either
import com.github.simonhauck.git.process.ProcessConfig
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class RevertCommandProcessWrapperTest {

    @TempDir lateinit var tempDir: File
    private lateinit var gitCommandApi: GitCommandApi

    @BeforeEach
    fun setup() {
        gitCommandApi = GitCommandProcessWrapper(config = ProcessConfig(workingDir = tempDir))
    }

    @Test
    fun `can create a git repository and correctly return the status`() {
        val actualInit = gitCommandApi.gitInit("main")
        assertThat(actualInit.isOk()).isTrue()

        val actualStatus = gitCommandApi.gitStatus()
        assertThat(actualStatus.isOk()).isTrue()
    }

    @Test
    fun `check that the git command fails if no git repository is available`() {
        val actual = gitCommandApi.gitStatus()

        assertThat(actual.isOk()).isFalse()
    }

    @Test
    fun `should be able to create a git repository and commit a file`() {
        gitCommandApi.gitInit("main")

        val file = File(tempDir, "file.txt")
        file.writeText("Hello World")

        val actualAdd = gitCommandApi.gitAdd("file.txt")
        assertThat(actualAdd.isOk()).isTrue()

        val actualCommit = gitCommandApi.gitCommit("Initial commit")
        assertThat(actualCommit.isOk()).isTrue()

        val actual = gitCommandApi.gitLog().get().map { it.message }
        assertThat(actual).containsExactly("Initial commit")
    }

    @Test
    fun `should contain the names of all local created branches`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.createBranch("feature-1")
        gitCommandApi.createBranch("feature-2")

        val actual = gitCommandApi.getLocalBranchNames()
        assertThat(actual.isOk()).isTrue()
        assertThat(actual.get()).contains("feature-1", "feature-2")
    }

    @Test
    fun `should be able to delete branches`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.createBranch("feature-1")
        gitCommandApi.createBranch("feature-2")

        val actual = gitCommandApi.deleteBranch("feature-1")
        assertThat(actual.isOk()).isTrue()

        val actualBranches = gitCommandApi.getLocalBranchNames()
        assertThat(actualBranches.get()).doesNotContain("feature-1")
    }

    private fun setupGitRepoWithInitialCommit() {
        gitCommandApi.gitInit("main")

        File("$tempDir/file.txt").writeText("Hello World")
        gitCommandApi.gitAdd("file.txt")
        gitCommandApi.gitCommit("Initial commit")
    }
}

fun <T, E> Either<T, E>.get(): E {
    return when (this) {
        is Either.Left -> throw IllegalStateException("Expected Right but got Left")
        is Either.Right -> this.value
    }
}
