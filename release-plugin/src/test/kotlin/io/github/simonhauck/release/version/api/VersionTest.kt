package io.github.simonhauck.release.version.api

import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class VersionTest {

    @TempDir lateinit var tmpDir: File

    @Test
    fun `from properties file should read the version from a given file and return the value as string`() {
        val file = tmpDir.resolve("version.properties").apply { writeText("version=1.2.0") }

        val actual = Version.fromPropertiesFile(file)

        assertThat(actual).isEqualTo("1.2.0")
    }
}
