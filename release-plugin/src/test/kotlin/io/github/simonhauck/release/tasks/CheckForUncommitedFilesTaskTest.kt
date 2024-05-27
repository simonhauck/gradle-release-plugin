package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class CheckForUncommitedFilesTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should not fail the action if all files are commited`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForUncommitedFilesTask>("testCheckForUncommitedFiles") {
                |    
                |}
                """
                    .trimMargin()
            )

            createLocalRepository()

            val runner = testKitRunner().withArguments("testCheckForUncommitedFiles").build()

            val actual = runner.task(":testCheckForUncommitedFiles")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `the task should fail and list the untracked, unstaged and staged files correctly`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForUncommitedFilesTask>("testCheckForUncommitedFiles") {
                |    
                |}
                """
                    .trimMargin()
            )

            createLocalRepository()
            updateVersionProperties("some-other-version")

            // Create the files
            client1WorkDir.resolve("newFile.txt").createNewFile()
            client1WorkDir.resolve("stagedFile.txt").createNewFile()
            client1Api.add("stagedFile.txt")

            val runner = testKitRunner().withArguments("testCheckForUncommitedFiles").buildAndFail()

            val actual = runner.task(":testCheckForUncommitedFiles")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "> The repository contains uncommited files:",
                    "   - staged: stagedFile.txt",
                    "   - unstaged: version.properties",
                    "   - untracked: newFile.txt",
                )
        }
}
