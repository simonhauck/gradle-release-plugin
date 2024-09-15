package io.github.simonhauck.release.version.api

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gradle.api.GradleException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class VersionIncrementStrategyParserApiTest {

    @TempDir lateinit var tmpDir: File
    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should throw if no valid arguments are supplied`() =
        testDriver(tmpDir) {
            val versionIncrementStrategyParserApi =
                VersionIncrementStrategyParserApi.create(client1Api)

            val parameters = emptyMap<String, String>()

            assertThatThrownBy {
                    versionIncrementStrategyParserApi.parseOrThrow(Version("1.0.0"), parameters)
                }
                .isInstanceOf(GradleException::class.java)
                .hasMessage(
                    "No valid version increment strategy found. Check the log or the documentation for the available parameters"
                )
        }

    @Test
    fun `should use the manual release type strategy if the required properties are set`() =
        testDriver(tmpDir) {
            val versionIncrementStrategyParserApi =
                VersionIncrementStrategyParserApi.create(client1Api)
            val parameters =
                mapOf("releaseVersion" to "1.1.0", "postReleaseVersion" to "1.2.0-SNAPSHOT")

            val actual =
                versionIncrementStrategyParserApi.parseOrThrow(Version("1.0.0"), parameters)

            assertThat(actual)
                .isEqualTo(ReleaseVersions(Version("1.1.0"), Version("1.2.0-SNAPSHOT")))
        }

    @Test
    fun `should use release type strategy when releaseType is specified`() {
        testDriver(tmpDir) {
            val versionIncrementStrategyParserApi =
                VersionIncrementStrategyParserApi.create(client1Api)

            val parameters = mapOf("releaseType" to "major")

            val actual =
                versionIncrementStrategyParserApi.parseOrThrow(Version("1.0.0"), parameters)

            assertThat(actual)
                .isEqualTo(ReleaseVersions(Version("2.0.0"), Version("2.0.1-SNAPSHOT")))
        }
    }
}
