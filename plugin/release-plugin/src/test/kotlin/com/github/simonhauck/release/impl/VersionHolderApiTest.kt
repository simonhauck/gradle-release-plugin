package com.github.simonhauck.release.impl

import java.nio.file.Path
import org.gradle.api.services.BuildServiceParameters
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

class VersionHolderApiTest {

    @Test
    fun `should write release version to file`(@TempDir tempDir: Path) {
        val versionHolder = createVersionHolder()
        val versionFile = tempDir.resolve("version.txt").toFile()

        versionHolder.setVersions(versionFile, "1.0.0", "1.0.1", "1.1.0")
        versionHolder.writeReleaseVersion()

        assertEquals("1.0.1", versionFile.readText())
    }

    @Test
    fun `should write next version to file`(@TempDir tempDir: Path) {
        val versionHolder = createVersionHolder()
        val versionFile = tempDir.resolve("version.txt").toFile()

        versionHolder.setVersions(versionFile, "1.0.0", "1.0.1", "1.1.0")
        versionHolder.writeNextVersion()

        assertEquals("1.1.0", versionFile.readText())
    }

    @Test
    fun `should throw exception when versions is null`() {
        val versionHolder = createVersionHolder()

        assertThrows<IllegalStateException> { versionHolder.writeReleaseVersion() }

        assertThrows<IllegalStateException> { versionHolder.writeNextVersion() }
    }

    private fun createVersionHolder(): VersionHolderApi {
        return object : VersionHolder() {
            override fun getParameters(): BuildServiceParameters.None {
                throw NotImplementedError("This is not used")
            }
        }
    }
}
