package com.github.simonhauck.release

import com.github.simonhauck.release.testdriver.SemanticVersioningPluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class SemanticVersioningPluginTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = SemanticVersioningPluginTestDriver()

    @Test
    fun `the version file should contain the next development version at the end`() =
        testDriver(tmpDir) {
            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PnextDevVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Disabled("This test can be enabled with the changes are commited")
    @Test
    fun `should revert all changes when the tag is already used`() =
        testDriver(tmpDir) {
            gitCommandApi.tag("1.2.0", "some message")
            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PnextDevVersion=1.2.1-SNAPSHOT"
                )
                .build()

            val initialVersion = tmpDir.resolve("version.properties").readText()
            assertThat(initialVersion).isEqualTo("version=1.2.1-SNAPSHOT")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PnextDevVersion=1.3.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }
}
