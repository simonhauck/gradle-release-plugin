package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionHolderApi
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
            val storeFile = createVersionStoreFile()

            appendContentToBuildGradle(
                """
                |tasks.register<WriteVersionTask>("writeTestReleaseVersion") {
                |   releaseVersionStore.set(file("${storeFile.path}"))
                |   versionType.set(VersionType.RELEASE)
                |   versionFile.set(layout.projectDirectory.file("version.properties"))
                |}
                 """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("writeTestReleaseVersion").build()

            val actual = runner.task(":writeTestReleaseVersion")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tempDir.resolve("version.properties").readText()).isEqualTo("version=2.0.0")
        }

    @Test
    fun `should write the next dev version in the file`() =
        testDriver(tempDir) {
            val storeFile = createVersionStoreFile()

            appendContentToBuildGradle(
                """
                |
                |tasks.register<WriteVersionTask>("writeTestReleaseVersion") {
                |   releaseVersionStore.set(file("${storeFile.path}"))
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
                .isEqualTo("version=2.0.1-SNAPSHOT")
        }

    @Test
    fun `task should be up to date when inputs are identical`() =
        testDriver(tempDir) {
            val storeFile = createVersionStoreFile()

            appendContentToBuildGradle(
                """
                |
                |tasks.register<WriteVersionTask>("writeTestReleaseVersion") {
                |   releaseVersionStore.set(file("${storeFile.path}"))
                |   versionType.set(VersionType.NEXT_DEV)
                |   versionFile.set(layout.projectDirectory.file("version.properties"))
                |}
                 """
                    .trimMargin()
            )
        }

    private fun createVersionStoreFile(): File {
        val storeFile = tempDir.resolve("version-store.properties").apply { createNewFile() }
        val releaseVersions = ReleaseVersions(Version("2.0.0"), Version("2.0.1-SNAPSHOT"))
        VersionHolderApi.create(storeFile).saveVersions(releaseVersions)
        return storeFile
    }
}
