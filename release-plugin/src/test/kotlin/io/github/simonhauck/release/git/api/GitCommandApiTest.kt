package io.github.simonhauck.release.git.api

import io.github.simonhauck.release.git.internal.commands.GitCommandProcessWrapper
import io.github.simonhauck.release.git.internal.process.ProcessConfig
import io.github.simonhauck.release.git.internal.process.ProcessWrapper
import io.github.simonhauck.release.testdriver.GitTestCommandService
import io.github.simonhauck.release.testdriver.assertIsOk
import io.github.simonhauck.release.testdriver.get
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class GitCommandApiTest {

    @TempDir lateinit var tempDir: File
    private lateinit var gitCommandApi: GitCommandApi
    private lateinit var processWrapper: ProcessWrapper

    @BeforeEach
    fun setup() {
        gitCommandApi = GitCommandProcessWrapper(config = ProcessConfig(workingDir = tempDir))
        processWrapper = ProcessWrapper()
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
    fun `git log should return the newest commit as last element`() {
        gitCommandApi.init("main")

        val file = File(tempDir, "file.txt")
        file.writeText("Hello World")

        gitCommandApi.add("file.txt").assertIsOk()
        gitCommandApi.commit("Initial commit").assertIsOk()

        file.writeText("new text")
        gitCommandApi.add("file.txt").assertIsOk()
        gitCommandApi.commit("Second commit").assertIsOk()

        val actual = gitCommandApi.log().get().map { it.message }
        assertThat(actual).containsExactly("Initial commit", "Second commit")
    }

    @Test
    fun `should correctly resolve the status of multiple files`() {
        setupGitRepoWithInitialCommit()

        File("$tempDir/unstaged.txt").writeText("unstaged")
        gitCommandApi.add(".").assertIsOk()
        gitCommandApi.commit("Commit file").assertIsOk()

        File("$tempDir/untracked.txt").writeText("Untracked")
        File("$tempDir/unstaged.txt").writeText("unstaged2")
        File("$tempDir/staged.txt").writeText("Staged")
        gitCommandApi.add("staged.txt").assertIsOk()

        val actual = gitCommandApi.status().assertIsOk()
        assertThat(actual.staged).containsExactly("staged.txt")
        assertThat(actual.untracked).containsExactly("untracked.txt")
        assertThat(actual.unstaged).containsExactly("unstaged.txt")
    }

    @Test
    fun `should reset the local changes so that the file is untracked again`() {
        setupGitRepoWithInitialCommit()

        File("$tempDir/someFile.txt").writeText("Hello World")
        gitCommandApi.add("someFile.txt").assertIsOk()
        val beforeCheck = gitCommandApi.status().assertIsOk()
        assertThat(beforeCheck.staged).containsExactly("someFile.txt")

        gitCommandApi.reset("someFile.txt").assertIsOk()

        val actual = gitCommandApi.status().assertIsOk()
        assertThat(actual.staged).isEmpty()
        assertThat(actual.untracked).containsExactly("someFile.txt")
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
    fun `should be able to set a remote branch and push a git commit that is remote available`(
        @TempDir remoteDir: File
    ) {
        val gitRepoDirectory = remoteDir.resolve("remote").apply { mkdir() }
        val gitClientDirectory = remoteDir.resolve("client").apply { mkdir() }
        val gitSererCommands = GitTestCommandService(gitRepoDirectory)
        val otherClientCommands = GitTestCommandService(gitClientDirectory)

        gitSererCommands.initBareRepository().assertIsOk()

        setupGitRepoWithInitialCommit()
        gitCommandApi.addRemoteAndSetUpstream("origin", gitRepoDirectory.absolutePath, "main")
        gitCommandApi.push().assertIsOk()

        // Check can the branch be checked out
        otherClientCommands.clone(gitRepoDirectory.absolutePath, ".", "main").assertIsOk()
        assertThat(gitClientDirectory.resolve("file.txt").readText()).isEqualTo("Hello World")
    }

    @Test
    fun `git push should fail if another client has already pushed a commit`(
        @TempDir remoteDir: File
    ) {
        val gitRepoDirectory = remoteDir.resolve("remote").apply { mkdir() }
        val gitClientDirectory = remoteDir.resolve("client").apply { mkdir() }

        val gitServerCommands = GitTestCommandService(gitRepoDirectory)
        val otherClientCommands = GitTestCommandService(gitClientDirectory)

        gitServerCommands.initBareRepository().assertIsOk()

        setupGitRepoWithInitialCommit()
        gitCommandApi.addRemoteAndSetUpstream("origin", gitRepoDirectory.absolutePath, "main")
        gitCommandApi.push().assertIsOk()

        // Push from another client
        otherClientCommands.clone(gitRepoDirectory.absolutePath, ".", "main").assertIsOk()
        gitClientDirectory.resolve("other.txt").apply { writeText("Hello World") }
        otherClientCommands.add("other.txt").assertIsOk()
        otherClientCommands.commit("Second commit").assertIsOk()
        otherClientCommands.push().assertIsOk()

        // Original client should fail
        tempDir.resolve("something.txt").apply { writeText("Hello World") }
        gitCommandApi.add("something.txt").assertIsOk()
        gitCommandApi.commit("Third commit").assertIsOk()
        val actual = gitCommandApi.push()

        assertThat(actual.isLeft()).isTrue()
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
