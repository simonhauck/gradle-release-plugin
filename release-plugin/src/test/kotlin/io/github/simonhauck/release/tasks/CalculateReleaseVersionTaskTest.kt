package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class CalculateReleaseVersionTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `task should be successful if a valid release versions for passed as command line parameters`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "calculateReleaseVersion",
                        "-PreleaseVersion=1.1.0",
                        "-PpostReleaseVersion=1.2.0-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `task should fail if no versions are provided`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            val runner = testKitRunner().withArguments("calculateReleaseVersion").buildAndFail()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
        }

    // TODO Simon.Hauck 2024-05-11 - add test to check for task caching
}
