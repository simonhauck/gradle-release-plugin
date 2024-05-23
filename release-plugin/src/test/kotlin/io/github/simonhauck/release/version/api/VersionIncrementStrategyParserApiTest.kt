package io.github.simonhauck.release.version.api

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gradle.api.GradleException
import org.junit.jupiter.api.Test

internal class VersionIncrementStrategyParserApiTest {

    private val versionIncrementStrategyParserApi = VersionIncrementStrategyParserApi.create()

    @Test
    fun `should throw if no valid arguments are supplied`() {
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
    fun `should return the release and postRelease version if they are specified as parameters`() {
        val parameters =
            mapOf("releaseVersion" to "1.1.0", "postReleaseVersion" to "1.2.0-SNAPSHOT")

        val actual = versionIncrementStrategyParserApi.parseOrThrow(Version("1.0.0"), parameters)

        assertThat(actual).isEqualTo(ReleaseVersions(Version("1.1.0"), Version("1.2.0-SNAPSHOT")))
    }

    @Test
    fun `should return the correct versions for a major release`() {
        val actual =
            versionIncrementStrategyParserApi.parseOrThrow(
                Version("1.0.0"),
                mapOf("releaseType" to "major")
            )

        val expected = ReleaseVersions(Version("2.0.0"), Version("2.0.1-SNAPSHOT"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should drop the snapshot tag for the release version on a patch level release`() {
        val actual =
            versionIncrementStrategyParserApi.parseOrThrow(
                Version("1.0.0-SNAPSHOT"),
                mapOf("releaseType" to "patch")
            )

        val expected = ReleaseVersions(Version("1.0.0"), Version("1.0.1-SNAPSHOT"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should increase the patch level for a patch release if not preRelease suffix is set`() {
        val actual =
            versionIncrementStrategyParserApi.parseOrThrow(
                Version("1.0.0"),
                mapOf("releaseType" to "patch")
            )

        val expected = ReleaseVersions(Version("1.0.1"), Version("1.0.2-SNAPSHOT"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should return the correct versions for a minor release`() {
        val actual =
            versionIncrementStrategyParserApi.parseOrThrow(
                Version("1.0.0"),
                mapOf("releaseType" to "minor")
            )

        val expected = ReleaseVersions(Version("1.1.0"), Version("1.1.1-SNAPSHOT"))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should return an exception if an invalid release type is selected`() {
        assertThatThrownBy {
                versionIncrementStrategyParserApi.parseOrThrow(
                    Version("1.0.0"),
                    mapOf("releaseType" to "unknown")
                )
            }
            .isInstanceOf(GradleException::class.java)
            .hasMessage(
                "No valid version increment strategy found. Check the log or the documentation for the available parameters"
            )
    }
}
