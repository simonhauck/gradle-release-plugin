package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class ReleasePluginTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `the version file should contain the next development version at the end`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `should use the version file location specified in the release extension`() =
        testDriver(tmpDir) {
            val fileName = "myOtherVersionFile.properties"

            val versionFile = File("$tmpDir/$fileName")
            versionFile.writeText("version=1.0.0")

            appendContentToBuildGradle(
                """
                    |release {
                    |    versionPropertyFile.set(layout.projectDirectory.file("$fileName"))
                    |}
                """
                    .trimMargin()
            )

            createValidGitRepository()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            assertThat(versionFile.readText()).isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `should revert all changes when the tag is already used`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            gitCommandApi.tag("1.2.0", "some message")
            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            val initialVersion = tmpDir.resolve("version.properties").readText()
            assertThat(initialVersion).isEqualTo("version=1.2.1-SNAPSHOT")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.3.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":commitReleaseVersion")?.outcome
            val releaseResult = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(releaseResult).isEqualTo(null)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }
}
