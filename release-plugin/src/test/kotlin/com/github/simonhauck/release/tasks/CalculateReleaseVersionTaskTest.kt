package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.testdriver.ReleasePluginTestDriver
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
            val runner =
                testKitRunner()
                    .withArguments(
                        "calculateReleaseVersion",
                        "-PreleaseVersion=1.1.0",
                        "-PnextDevVersion=1.2.0-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `task should fail if no versions are provided`() =
        testDriver(tmpDir) {
            val runner = testKitRunner().withArguments("calculateReleaseVersion").buildAndFail()

            val actual = runner.task(":calculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
        }
}
