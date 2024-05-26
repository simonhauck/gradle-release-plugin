package io.github.simonhauck.release.git.api

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import io.github.simonhauck.release.testdriver.get
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class GitCommandApiTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `can create a git repository and correctly return the status`() =
        testDriver(tmpDir) {
            client1Api.init("main").assertIsOk()

            client1Api.status().assertIsOk()
        }

    @Test
    fun `check that the git command fails if no git repository is available`() =
        testDriver(tmpDir) {
            val actual = client1Api.status()

            assertThat(actual.isOk()).isFalse()
        }

    @Test
    fun `should be able to create a git repository and commit a file`() =
        testDriver(tmpDir) {
            client1Api.init("main")

            client1Api.add(".").assertIsOk()
            client1Api.commit("Initial commit").assertIsOk()

            val actual = client1Api.log().get().map { it.message }
            assertThat(actual).containsExactly("Initial commit")
        }

    @Test
    fun `git log should return the newest commit as last element`() =
        testDriver(tmpDir) {
            createLocalRepository()

            appendContentToBuildGradle("some content")
            client1Api.add(".").assertIsOk()
            client1Api.commit("Second commit").assertIsOk()

            val actual = client1Api.log().get().map { it.message }
            assertThat(actual).containsExactly("Initial commit", "Second commit")
        }

    @Test
    fun `should correctly resolve the status of multiple files`() =
        testDriver(tmpDir) {
            createLocalRepository()

            File("$client1WorkDir/unstaged.txt").writeText("unstaged")
            client1Api.add(".").assertIsOk()
            client1Api.commit("Commit file").assertIsOk()

            File("$client1WorkDir/untracked.txt").writeText("Untracked")
            File("$client1WorkDir/unstaged.txt").writeText("unstaged2")
            File("$client1WorkDir/staged.txt").writeText("Staged")
            client1Api.add("staged.txt").assertIsOk()

            val actual = client1Api.status().assertIsOk()
            assertThat(actual.staged).containsExactly("staged.txt")
            assertThat(actual.untracked).containsExactly("untracked.txt")
            assertThat(actual.unstaged).containsExactly("unstaged.txt")
        }

    @Test
    fun `should reset the local changes so that the file is untracked again`() =
        testDriver(tmpDir) {
            createLocalRepository()

            File("$client1WorkDir/someFile.txt").writeText("Hello World")
            client1Api.add("someFile.txt").assertIsOk()
            val beforeCheck = client1Api.status().assertIsOk()
            assertThat(beforeCheck.staged).containsExactly("someFile.txt")

            client1Api.reset("someFile.txt").assertIsOk()

            val actual = client1Api.status().assertIsOk()
            assertThat(actual.staged).isEmpty()
            assertThat(actual.untracked).containsExactly("someFile.txt")
        }

    @Test
    fun `should contain the names of all local created branches`() =
        testDriver(tmpDir) {
            createLocalRepository()

            client1Api.createBranch("feature-1").assertIsOk()
            client1Api.createBranch("feature-2").assertIsOk()

            val actual = client1Api.getLocalBranchNames().assertIsOk()
            assertThat(actual).contains("feature-1", "feature-2")
        }

    @Test
    fun `should be able to delete branches`() =
        testDriver(tmpDir) {
            createLocalRepository()

            client1Api.createBranch("feature-1").assertIsOk()
            client1Api.createBranch("feature-2").assertIsOk()

            client1Api.deleteBranch("feature-1").assertIsOk()

            val actualBranches = client1Api.getLocalBranchNames().assertIsOk()
            assertThat(actualBranches).doesNotContain("feature-1")
        }

    @Test
    fun `the file should contain the original content after the commit was deleted`() =
        testDriver(tmpDir) {
            createLocalRepository()

            repeat(2) {
                File("$client1WorkDir/newFile.txt").writeText("Commit number $it")
                client1Api.add("newFile.txt")
                client1Api.commit("commit number $it")
            }

            val commandResult = client1Api.deleteLastCommit()
            assertThat(commandResult.isOk()).isTrue()

            val actual = File("$client1WorkDir/newFile.txt").readText()
            assertThat(actual).isEqualTo("Commit number 0")
        }

    @Test
    fun `the file should be deleted when the commit is reverted where the file was added`() =
        testDriver(tmpDir) {
            createLocalRepository()

            val createdFile = File("$client1WorkDir/newFile.txt").apply { writeText("Hello World") }
            client1Api.add("newFile.txt").assertIsOk()
            client1Api.commit("Add new file").assertIsOk()

            client1Api.deleteLastCommit().assertIsOk()

            assertThat(createdFile).doesNotExist()
        }

    @Test
    fun `should leave unstaged, untracked and staged unchanged when dropping the last commit`() =
        testDriver(tmpDir) {
            createLocalRepository()

            updateVersionProperties("1.0.0")
            val unstagedFile =
                client1WorkDir.resolve("unstaged.txt").apply { writeText("Unstaged") }
            val stagedFile = client1WorkDir.resolve("staged.txt").apply { writeText("Staged") }
            client1Api.add(".").assertIsOk()
            client1Api.commit("commit to be reverted").assertIsOk()

            // This is the post commit
            val untrackedFile =
                client1WorkDir.resolve("untracked.txt").apply { writeText("Untracked") }
            stagedFile.writeText("new staged content")
            unstagedFile.writeText("new unstaged content")
            client1Api.add("staged.txt")

            client1Api.deleteLastCommit().assertIsOk()

            assertThat(untrackedFile).content().isEqualTo("Untracked")
            assertThat(stagedFile).content().isEqualTo("new staged content")
            assertThat(unstagedFile).content().isEqualTo("new unstaged content")
        }

    @Test
    fun `should be able to set a remote branch and push a git commit that is remote available`() =
        testDriver(tmpDir) {
            serverApi.initBareRepository()

            createLocalRepository()
            client1Api.addRemoteAndSetUpstream("origin", serverWorkDir.absolutePath, "main")
            client1Api.push().assertIsOk()

            // Check can the branch be checked out
            client2Api.clone(serverWorkDir.absolutePath, ".", "main").assertIsOk()
            assertThat(client2WorkDir.resolve("build.gradle.kts")).exists()
        }

    @Test
    fun `git push should fail if another client has already pushed a commit`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            // Push from another client
            cloneForClient2()
            client2WorkDir.resolve("other.txt").apply { writeText("Hello World") }
            client2Api.add("other.txt").assertIsOk()
            client2Api.commit("Second commit").assertIsOk()
            client2Api.push().assertIsOk()

            // Original client should fail
            client1WorkDir.resolve("something.txt").apply { writeText("Hello World") }
            client1Api.add("something.txt").assertIsOk()
            client1Api.commit("Third commit").assertIsOk()
            val actual = client1Api.push()

            assertThat(actual.isLeft()).isTrue()
        }

    @Test
    fun `should be able to rebase the commits if another client has already pushed changes`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            cloneForClient2()
            client2WorkDir.resolve("other.txt").apply { writeText("Hello World") }
            client2Api.add("other.txt").assertIsOk()
            client2Api.commit("Client2 commit")
            client2Api.push()

            appendContentToBuildGradle("some content")
            client1Api.add(".").assertIsOk()
            client1Api.commit("Client1 commit")
            client1Api.pullRebase()

            val messages = client1Api.log().assertIsOk().map { it.message }
            assertThat(messages)
                .containsExactly("Initial commit", "Client2 commit", "Client1 commit")
        }

    @Test
    fun `should be able to create and list tags`() =
        testDriver(tmpDir) {
            createLocalRepository()

            client1Api.tag("v1.0", "Initial release").assertIsOk()
            client1Api.tag("v1.1", "Second release").assertIsOk()

            val actual = client1Api.listTags().assertIsOk()

            assertThat(actual).containsExactly("v1.0", "v1.1")
        }

    @Test
    fun `should be able to delete a tag`() =
        testDriver(tmpDir) {
            createLocalRepository()

            client1Api.tag("v1.0", "Initial release").assertIsOk()
            client1Api.tag("v1.1", "Second release").assertIsOk()

            client1Api.deleteLocalTag("v1.0").assertIsOk()

            val actual = client1Api.listTags().assertIsOk()
            assertThat(actual).containsExactly("v1.1")
        }

    @Test
    fun `should return a GitError with an descriptive error message containing the console output of the git command`() =
        testDriver(tmpDir) {
            val actual = client1Api.status()

            assertThat(actual.leftOrNull()?.message?.lines())
                .containsExactly(
                    "Failed to execute command: 'status --porcelain'",
                    "Command finished with non zero exit code (code=128)",
                    "--- Git output ---",
                    "fatal: not a git repository (or any of the parent directories): .git",
                    "--- End of output ---"
                )
        }
}
