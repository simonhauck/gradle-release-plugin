package io.github.simonhauck.release.version.api

import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gradle.api.GradleException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class VersionHolderApiTest {
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

        val file = tempDir.resolve("version.properties")

        versionHolderApi.writeVersionPropertyToFile(file, version)

        val actual = file.readText()

        assertThat(actual).isEqualTo("version=1.0.0")
    }

    @Test
    fun `should return the version from the properties file`() {
        val versionHolderApi = createVersionHolder()

        val file = File(tempDir, "version.properties").apply { writeText("version=1.0.0") }

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
            .hasMessage("No 'version' property found in $file")
    }

    @Test
    fun `should leave unrelated properties and comments in the file untouched`() {
        val versionHolderApi = createVersionHolder()

        val file =
            File(tempDir, "version.properties").apply {
                val content =
                    listOf(
                            "firstProperty=something",
                            "#This is a random comment",
                            "version=1.0.0",
                            "unrelated=property",
                        )
                        .joinToString(System.lineSeparator())
                writeText(content)
            }

        versionHolderApi.writeVersionPropertyToFile(file, Version("1.0.1"))

        val actual = file.readLines()

        assertThat(actual)
            .containsExactly(
                "firstProperty=something",
                "#This is a random comment",
                "version=1.0.1",
                "unrelated=property",
            )
    }

    private fun createVersionHolder(): VersionHolderApi {
        val file = tempDir.resolve("test.properties").apply { createNewFile() }

        return VersionHolderApi.create(file)
    }
}
