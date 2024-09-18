package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class ReleaseTypeSelectionStrategyTest {

    @TempDir private lateinit var tmpDir: File
    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun getStrategyName() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val strategyName = strategy.strategyName

            assertThat(strategyName).isEqualTo("ReleaseType selection")
        }

    @Test
    fun getRequiredPropertyDescription() {
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val requiredPropertyDescription = strategy.requiredPropertyDescription

            assertThat(requiredPropertyDescription)
                .containsExactly(
                    "releaseType - The type of release (major, minor, patch)",
                    "preReleaseType - (Optional) Type of pre-release (e.g. alpha, RC, beta, ...). A counter will be automatically applied.",
                )
        }
    }

    @Test
    fun `should return the correct versions for a major release`() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val actual = strategy.tryParse(Version("1.0.0"), mapOf("releaseType" to "major"))

            val expected = ReleaseVersions(Version("2.0.0"), Version("2.0.1-SNAPSHOT"))
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `should drop the snapshot tag for the release version on a patch level release`() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val actual =
                strategy.tryParse(Version("1.0.0-SNAPSHOT"), mapOf("releaseType" to "patch"))

            val expected = ReleaseVersions(Version("1.0.0"), Version("1.0.1-SNAPSHOT"))
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `should increase the patch level for a patch release if not preRelease suffix is set`() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)
            val actual = strategy.tryParse(Version("1.0.0"), mapOf("releaseType" to "patch"))

            val expected = ReleaseVersions(Version("1.0.1"), Version("1.0.2-SNAPSHOT"))
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `should return the correct versions for a minor release`() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)
            val actual = strategy.tryParse(Version("1.0.0"), mapOf("releaseType" to "minor"))

            val expected = ReleaseVersions(Version("1.1.0"), Version("1.1.1-SNAPSHOT"))
            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `should create a pre-release when the release suffix is specified`() {
        testDriver(tmpDir) {
            createLocalRepository()

            val strategy = ReleaseTypeSelectionStrategy(client1Api)
            val actual =
                strategy.tryParse(
                    Version("1.0.0"),
                    mapOf("releaseType" to "patch", "preReleaseType" to "rc"),
                )

            val expected = ReleaseVersions(Version("1.0.1-rc"), Version("1.0.0"))
            assertThat(actual).isEqualTo(expected)
        }
    }

    @Test
    fun `should revert the post release version back to the original version when a release with a pre release version was triggered`() {
        testDriver(tmpDir) {
            createLocalRepository()

            val strategy = ReleaseTypeSelectionStrategy(client1Api)
            val actual =
                strategy.tryParse(
                    Version("1.0.0"),
                    mapOf("releaseType" to "patch", "preReleaseType" to "rc"),
                )

            val expected = ReleaseVersions(Version("1.0.1-rc"), Version("1.0.0"))
            assertThat(actual).isEqualTo(expected)
        }
    }

    @Test
    fun `should return null if an unknown releaseType is set`() =
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val actual = strategy.tryParse(Version("1.0.0"), mapOf("releaseType" to "unknown"))

            assertThat(actual).isNull()
        }

    @Test
    fun `should return null if no releaseType property is specified`() {
        testDriver(tmpDir) {
            val strategy = ReleaseTypeSelectionStrategy(client1Api)

            val actual = strategy.tryParse(Version("1.0.0"), emptyMap())

            assertThat(actual).isEqualTo(null)
        }
    }
}
