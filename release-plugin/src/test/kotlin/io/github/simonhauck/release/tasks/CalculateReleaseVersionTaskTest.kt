package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class CalculateReleaseVersionTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    // TODO Simon.Hauck 2024-05-12 - Rewrite tests to create task explicitly ?
    @Test
    fun `task should be successful if a valid release versions for passed as command line parameters`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withArguments(
                        "calculateReleaseVersion",
                        "-PreleaseVersion=1.1.0",
                        "-PpostReleaseVersion=1.2.0-SNAPSHOT",
                    )
                    .build()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `task should fail if no versions are provided`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("calculateReleaseVersion").buildAndFail()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
        }

    @Test
    fun `task should not be up to date when invoked twice because the git repository could change`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            val args =
                arrayOf(
                    "calculateReleaseVersion",
                    "-PreleaseVersion=1.1.0",
                    "-PpostReleaseVersion=1.2.0-SNAPSHOT",
                )

            testKitRunner().withArguments(*args).build()
            val runner = testKitRunner().withArguments(*args).build()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }
}
