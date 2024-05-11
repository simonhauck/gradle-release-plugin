package com.github.simonhauck.release.version.internal

import com.github.simonhauck.release.version.api.VersionIncrementStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VersionIncrementStrategyParserTest {
    private val versionIncrementStrategyParser = VersionIncrementStrategyParser()

    @Test
    fun `parseVersionIncrementStrategy returns SpecifyVersionExplicitly when both versions are provided`() {
        val parameters = mapOf("releaseVersion" to "1.0.0", "nextDevVersion" to "1.0.1")

        val actual = versionIncrementStrategyParser.parse(parameters)

        val expected = VersionIncrementStrategy.SpecifyExplicitly("1.0.0", "1.0.1")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when releaseVersion is missing`() {
        val parameters = mapOf("nextDevVersion" to "1.0.1")

        val result = versionIncrementStrategyParser.parse(parameters)

        assertThat(result).isNull()
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when nextDevVersion is missing`() {
        val parameters = mapOf("releaseVersion" to "1.0.0")

        val result = versionIncrementStrategyParser.parse(parameters)

        assertThat(result).isNull()
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when both versions are missing`() {
        val parameters = emptyMap<String, String>()

        val result = versionIncrementStrategyParser.parse(parameters)

        assertThat(result).isNull()
    }
}
