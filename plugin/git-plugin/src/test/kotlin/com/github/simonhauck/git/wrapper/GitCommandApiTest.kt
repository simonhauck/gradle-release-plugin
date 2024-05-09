package com.github.simonhauck.git.wrapper

import arrow.core.Either
import com.github.simonhauck.git.process.ProcessConfig
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class GitCommandApiTest {

    @TempDir lateinit var tempDir: File
    private lateinit var gitCommandApi: GitCommandApi

    @BeforeEach
    fun setup() {
        gitCommandApi = GitCommandProcessWrapper(config = ProcessConfig(workingDir = tempDir))
    }

    @Test
    fun `can create a git repository and correctly return the status`() {
        gitCommandApi.init("main").assertIsOk()

        gitCommandApi.status().assertIsOk()
    }

    @Test
    fun `check that the git command fails if no git repository is available`() {
        val actual = gitCommandApi.status()

        assertThat(actual.isOk()).isFalse()
    }

    @Test
    fun `should be able to create a git repository and commit a file`() {
        gitCommandApi.init("main")

        val file = File(tempDir, "file.txt")
        file.writeText("Hello World")

        gitCommandApi.add("file.txt").assertIsOk()
        gitCommandApi.commit("Initial commit").assertIsOk()

        val actual = gitCommandApi.log().get().map { it.message }
        assertThat(actual).containsExactly("Initial commit")
    }

    @Test
    fun `should contain the names of all local created branches`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.createBranch("feature-1").assertIsOk()
        gitCommandApi.createBranch("feature-2").assertIsOk()

        val actual = gitCommandApi.getLocalBranchNames().assertIsOk()
        assertThat(actual).contains("feature-1", "feature-2")
    }

    @Test
    fun `should be able to delete branches`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.createBranch("feature-1").assertIsOk()
        gitCommandApi.createBranch("feature-2").assertIsOk()

        gitCommandApi.deleteBranch("feature-1").assertIsOk()

        val actualBranches = gitCommandApi.getLocalBranchNames().assertIsOk()
        assertThat(actualBranches).doesNotContain("feature-1")
    }

    @Test
    fun `the file should contain the original content after the commit was deleted`() {
        setupGitRepoWithInitialCommit()

        repeat(2) {
            File("$tempDir/newFile.txt").writeText("Commit number $it")
            gitCommandApi.add("newFile.txt")
            gitCommandApi.commit("commit number $it")
        }

        val commandResult = gitCommandApi.deleteLastCommit()
        assertThat(commandResult.isOk()).isTrue()

        val actual = File("$tempDir/newFile.txt").readText()
        assertThat(actual).isEqualTo("Commit number 0")
    }

    @Test
    fun `the file should be deleted when the commit is reverted where the file was added`() {
        setupGitRepoWithInitialCommit()

        File("$tempDir/newFile.txt").writeText("Hello World")
        gitCommandApi.add("newFile.txt").assertIsOk()
        gitCommandApi.commit("Add new file").assertIsOk()

        gitCommandApi.deleteLastCommit().assertIsOk()

        val actual = File("$tempDir/newFile.txt").exists()
        assertThat(actual).isFalse()
    }

    @Test
    fun `should be able to create and list tags`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.tag("v1.0", "Initial release").assertIsOk()
        gitCommandApi.tag("v1.1", "Second release").assertIsOk()

        val actual = gitCommandApi.listTags().assertIsOk()

        assertThat(actual).containsExactly("v1.0", "v1.1")
    }

    @Test
    fun `should be able to delete a tag`() {
        setupGitRepoWithInitialCommit()

        gitCommandApi.tag("v1.0", "Initial release").assertIsOk()
        gitCommandApi.tag("v1.1", "Second release").assertIsOk()

        gitCommandApi.deleteLocalTag("v1.0").assertIsOk()

        val actual = gitCommandApi.listTags().assertIsOk()
        assertThat(actual).containsExactly("v1.1")
    }

    private fun setupGitRepoWithInitialCommit() {
        gitCommandApi.init("main")

        File("$tempDir/file.txt").writeText("Hello World")
        gitCommandApi.add("file.txt")
        gitCommandApi.commit("Initial commit")
    }
}

private fun <T> Either<GitError, T>.assertIsOk(): T {
    assertThat(isOk()).isTrue()
    return get()
}

fun <T, E> Either<T, E>.get(): E {
    return when (this) {
        is Either.Left -> throw IllegalStateException("Expected Right but got Left")
        is Either.Right -> this.value
    }
}
