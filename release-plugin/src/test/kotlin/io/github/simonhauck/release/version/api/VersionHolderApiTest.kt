package io.github.simonhauck.release.version.api

import io.github.simonhauck.release.version.internal.VersionHolder
import java.nio.file.Path
import org.assertj.core.api.Assertions.assertThat
import org.gradle.api.services.BuildServiceParameters
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir

class VersionHolderApiTest {

    @Test
    fun `should write release version to file`(@TempDir tempDir: Path) {
        val versionHolder = createVersionHolder()
        val versionFile = tempDir.resolve("version.txt").toFile()

        versionHolder.setVersions(versionFile, "1.0.0", "1.0.1", "1.1.0")
        versionHolder.writeReleaseVersion(versionFile)

        assertThat(versionFile.readText()).isEqualTo("version=1.0.1")
    }

    @Test
    fun `should write next version to file`(@TempDir tempDir: Path) {
        val versionHolder = createVersionHolder()
        val versionFile = tempDir.resolve("version.txt").toFile()

        versionHolder.setVersions(versionFile, "1.0.0", "1.0.1", "1.1.0")
        versionHolder.writeNextVersion(versionFile)

        assertThat(versionFile.readText()).isEqualTo("version=1.1.0")
    }

    @Test
    fun `should throw exception when versions is null`(@TempDir tempDir: Path) {
        val versionHolder = createVersionHolder()
        val versionFile = tempDir.resolve("version.txt").toFile()

        assertThrows<IllegalStateException> { versionHolder.writeReleaseVersion(versionFile) }

        assertThrows<IllegalStateException> { versionHolder.writeNextVersion(versionFile) }
    }

    private fun createVersionHolder(): VersionHolderApi {
        return object : VersionHolder() {
            override fun getParameters(): BuildServiceParameters.None {
                throw NotImplementedError("This is not used")
            }
        }
    }
}
