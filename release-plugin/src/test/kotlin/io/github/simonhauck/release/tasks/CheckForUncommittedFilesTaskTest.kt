package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class CheckForUncommittedFilesTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should not fail the action if all files are commited`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                        |tasks.register<CheckForUncommittedFilesTask>("testCheckForUncommittedFiles") {
                        |    
                        |}
                        """
                    .trimMargin()
            )

            client1Api.createLocalRepository()

            val runner = testKitRunner().withArguments("testCheckForUncommittedFiles").build()

            val actual = runner.task(":testCheckForUncommittedFiles")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `the task should fail and list the untracked, unstaged and staged files correctly`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                        |tasks.register<CheckForUncommittedFilesTask>("testCheckForUncommittedFiles") {
                        |    
                        |}
                        """
                    .trimMargin()
            )

            client1Api.createLocalRepository()
            client1WorkDir.updateVersionProperties("some-other-version")

            // Create the files
            client1WorkDir.resolve("newFile.txt").createNewFile()
            client1WorkDir.resolve("stagedFile.txt").createNewFile()
            client1Api.add("stagedFile.txt")

            val runner =
                testKitRunner().withArguments("testCheckForUncommittedFiles").buildAndFail()

            val actual = runner.task(":testCheckForUncommittedFiles")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "> The repository contains uncommitted files:",
                    "   - staged: stagedFile.txt",
                    "   - unstaged: version.properties",
                    "   - untracked: newFile.txt",
                )
        }

    @Test
    fun `should revert changes with the GitCommandHistory if the command fails`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                            |
                            |val commitTask = tasks.register<CommitAndTagTask>("commitAndTagVersion") {
                            |    commitMessage.set("testCommit")
                            |    gitAddFilePattern.set(listOf(file("version.properties")))
                            |}
                            |tasks.register<CheckForUncommittedFilesTask>("testCheckForUncommittedFiles") {
                            |   dependsOn(commitTask)
                            |}
                        """
                    .trimMargin()
            )

            client1WorkDir.updateVersionProperties("1.0.0")
            client1Api.createLocalRepository()

            // The version file is committed, the other file triggers the failed build
            client1WorkDir.updateVersionProperties("1.1.0")
            client1WorkDir.resolve("notCommittedFile.txt").createNewFile()

            val runner =
                testKitRunner().withArguments("testCheckForUncommittedFiles").buildAndFail()

            val actual = runner.task(":testCheckForUncommittedFiles")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(client1WorkDir.readVersionPropertiesFile()).isEqualTo("version=1.0.0")
        }
}
