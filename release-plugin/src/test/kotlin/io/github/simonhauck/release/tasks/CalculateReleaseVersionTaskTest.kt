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

    @Test
    fun `should write the provided release and post release version to the releaseVersionStore`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                |tasks.register<CalculateReleaseVersionTask>("testCalculateReleaseVersion") {
                |    versionPropertyFile = file("version.properties")
                |    commandLineParameters = mapOf("releaseVersion" to "1.1.0", "postReleaseVersion" to "1.2.0-SNAPSHOT")
                |    releaseTagName = "v{version}"
                |    releaseVersionStore= layout.buildDirectory.file("release-version-store.txt")
                |}
                """
                    .trimMargin()
            )
            client1Api.createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("testCalculateReleaseVersion").build()
            val actual = runner.task(":testCalculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.resolve("build/release-version-store.txt").readLines())
                .containsExactly("postReleaseVersion=1.2.0-SNAPSHOT", "releaseVersion=1.1.0")
        }

    @Test
    fun `should write the calculated release and post release version in the file`() =
        testDriver(tmpDir) {
            client1WorkDir.updateVersionProperties("1.0.0")
            client1WorkDir.appendContentToBuildGradle(
                """
                |tasks.register<CalculateReleaseVersionTask>("testCalculateReleaseVersion") {
                |    versionPropertyFile = file("version.properties")
                |    commandLineParameters = mapOf("releaseType" to "major")
                |    releaseTagName = "v{version}"
                |    releaseVersionStore= layout.buildDirectory.file("release-version-store.txt")
                |}
                """
                    .trimMargin()
            )
            client1Api.createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("testCalculateReleaseVersion").build()
            val actual = runner.task(":testCalculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.resolve("build/release-version-store.txt").readLines())
                .containsExactly("postReleaseVersion=2.0.1-SNAPSHOT", "releaseVersion=2.0.0")
        }

    @Test
    fun `should create a pre-release version if a pre-release type is provided`() =
        testDriver(tmpDir) {
            client1WorkDir.updateVersionProperties("1.0.0")
            client1WorkDir.appendContentToBuildGradle(
                """
                |tasks.register<CalculateReleaseVersionTask>("testCalculateReleaseVersion") {
                |    versionPropertyFile = file("version.properties")
                |    commandLineParameters = mapOf("releaseType" to "major", "preReleaseType" to "rc")
                |    releaseTagName = "v{version}"
                |    releaseVersionStore= layout.buildDirectory.file("release-version-store.txt")
                |}
                """
                    .trimMargin()
            )
            client1Api.createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("testCalculateReleaseVersion").build()
            val actual = runner.task(":testCalculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.resolve("build/release-version-store.txt").readLines())
                .containsExactly("postReleaseVersion=1.0.0", "releaseVersion=2.0.0-rc1")
        }

    @Test
    fun `task should fail if no versions are provided`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                |tasks.register<CalculateReleaseVersionTask>("testCalculateReleaseVersion") {
                |    versionPropertyFile = file("version.properties")
                |    commandLineParameters = mapOf("someRandomProperties" to "xy")
                |    releaseTagName = "v{version}"
                |    releaseVersionStore= layout.buildDirectory.file("release-version-store.txt")
                |}
                """
                    .trimMargin()
            )
            client1Api.createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("testCalculateReleaseVersion").buildAndFail()
            val actual = runner.task(":testCalculateReleaseVersion")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "No version increment strategy found",
                    "Available strategy: Manual Version Selection",
                    "	 releaseVersion - The version to release",
                    "	 postReleaseVersion - The version after the release",
                    "Available strategy: ReleaseType selection",
                    "	 releaseType - The type of release (major, minor, patch)",
                    "	 preReleaseType - (Optional) Type of pre-release (e.g. alpha, RC, beta, ...). A counter will be automatically applied.",
                )
        }

    @Test
    fun `task should not be up to date when invoked twice because the git repository could change`() =
        testDriver(tmpDir) {
            client1WorkDir.appendContentToBuildGradle(
                """
                |tasks.register<CalculateReleaseVersionTask>("testCalculateReleaseVersion") {
                |    versionPropertyFile = file("version.properties")
                |    commandLineParameters = mapOf("releaseType" to "major")
                |    releaseTagName = "v{version}"
                |    releaseVersionStore= layout.buildDirectory.file("release-version-store.txt")
                |}
                """
                    .trimMargin()
            )

            client1Api.createValidRepositoryWithRemote()

            repeat(2) {
                val runner = testKitRunner().withArguments("testCalculateReleaseVersion").build()
                val actual = runner.task(":testCalculateReleaseVersion")

                assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            }
        }
}
