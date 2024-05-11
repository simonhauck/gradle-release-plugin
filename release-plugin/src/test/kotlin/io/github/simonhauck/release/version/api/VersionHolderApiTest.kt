package io.github.simonhauck.release.version.api

import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gradle.api.GradleException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class VersionHolderApiTest {
    @TempDir lateinit var tempDir: File

    @Test
    fun `should correctly save and load the releaseVersions`() {
        val releaseVersions = ReleaseVersions(Version("1.0.0"), Version("1.0.1"))
        val versionHolderApi = createVersionHolder()

        versionHolderApi.saveVersions(releaseVersions)

        val actual = versionHolderApi.loadVersions()

        assertThat(actual).isEqualTo(releaseVersions)
    }

    @Test
    fun `loadReleaseVersions should return null if file does not exist`() {

        val versionHolderApi = createVersionHolder()

        val actual = versionHolderApi.loadVersions()

        assertThat(actual).isNull()
    }

    @Test
    fun `should write the given version to the properties file`() {
        val versionHolderApi = createVersionHolder()
        val version = Version("1.0.0")

        val file = File(tempDir, "version.properties").apply { createNewFile() }

        versionHolderApi.writeVersionPropertyToFile(file, version)

        val actual = file.readText()

        assertThat(actual).isEqualTo("version=1.0.0")
    }

    @Test
    fun `should return the version from the properties file`() {
        val versionHolderApi = createVersionHolder()

        val file =
            File(tempDir, "version.properties").apply {
                createNewFile()
                writeText("version=1.0.0")
            }

        val actual = versionHolderApi.loadVersionFromFileOrThrow(file)

        val expected = Version("1.0.0")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should throw an exception when there is no version property`() {
        val versionHolderApi = createVersionHolder()

        val file = File(tempDir, "version.properties").apply { createNewFile() }

        assertThatThrownBy { versionHolderApi.loadVersionFromFileOrThrow(file) }
            .isInstanceOf(GradleException::class.java)
            .hasMessage("No version property found in $file")
    }

    private fun createVersionHolder(): VersionHolderApi {
        val file = tempDir.resolve("test.properties").apply { createNewFile() }

        return VersionHolderApi.create(file)
    }
}
