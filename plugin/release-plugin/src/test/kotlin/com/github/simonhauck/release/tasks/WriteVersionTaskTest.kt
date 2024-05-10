package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class WriteVersionTaskTest {
    @TempDir lateinit var tempDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should write the release version to the given file`() =
        testDriver(tempDir) {
            appendContentToBuildGradle(
                """
                |val calculateVersionTask = tasks.register<CalculateReleaseVersionTask>("calculateVersion") {
                |    versionPropertyFile.set(layout.projectDirectory.file("version.properties"))
                |    commandLineParameters.set(mapOf("nextDevVersion" to "1.0.2-SNAPSHOT", "releaseVersion" to "1.0.1"))
                |}
                |
                |tasks.register<WriteVersionTask>("writeTestReleaseVersion") {
                |   dependsOn(calculateVersionTask)
                |   versionType.set(VersionType.RELEASE)
                |   versionFile.set(layout.projectDirectory.file("version.properties"))
                |}
                 """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("writeTestReleaseVersion").build()

            val actual = runner.task(":writeTestReleaseVersion")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tempDir.resolve("version.properties").readText()).isEqualTo("version=1.0.1")
        }

    @Test
    fun `should write the next dev version in the file`() =
        testDriver(tempDir) {
            appendContentToBuildGradle(
                """
                |val calculateVersionTask = tasks.register<CalculateReleaseVersionTask>("calculateVersion") {
                |    versionPropertyFile.set(layout.projectDirectory.file("version.properties"))
                |    commandLineParameters.set(mapOf("nextDevVersion" to "1.0.2-SNAPSHOT", "releaseVersion" to "1.0.1"))
                |}
                |
                |tasks.register<WriteVersionTask>("writeTestReleaseVersion") {
                |   dependsOn(calculateVersionTask)
                |   versionType.set(VersionType.NEXT_DEV)
                |   versionFile.set(layout.projectDirectory.file("version.properties"))
                |}
                 """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("writeTestReleaseVersion").build()

            val actual = runner.task(":writeTestReleaseVersion")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tempDir.resolve("version.properties").readText())
                .isEqualTo("version=1.0.2-SNAPSHOT")
        }
}
