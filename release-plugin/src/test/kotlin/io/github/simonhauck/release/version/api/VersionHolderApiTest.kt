package io.github.simonhauck.release.version.api

import java.io.File
import org.assertj.core.api.Assertions.assertThat
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

    private fun createVersionHolder(): VersionHolderApi {
        val file = tempDir.resolve("test.properties").apply { createNewFile() }

        return VersionHolderApi.create(file)
    }
}
