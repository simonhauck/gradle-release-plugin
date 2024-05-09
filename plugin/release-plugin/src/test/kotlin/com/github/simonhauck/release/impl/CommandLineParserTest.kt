package com.github.simonhauck.release.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommandLineParserTest {
    private val parser = CommandLineParser()

    @Test
    fun `parseVersionIncrementStrategy returns SpecifyVersionExplicitly when both versions are provided`() {
        val parameters = mapOf("releaseVersion" to "1.0.0", "nextDevVersion" to "1.0.1")

        val actual = parser.parseVersionIncrementStrategy(parameters)

        val expected = VersionIncrementStrategy.SpecifyVersionExplicitly("1.0.0", "1.0.1")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when releaseVersion is missing`() {
        val parameters = mapOf("nextDevVersion" to "1.0.1")

        val result = parser.parseVersionIncrementStrategy(parameters)

        assertThat(result).isNull()
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when nextDevVersion is missing`() {
        val parameters = mapOf("releaseVersion" to "1.0.0")

        val result = parser.parseVersionIncrementStrategy(parameters)

        assertThat(result).isNull()
    }

    @Test
    fun `parseVersionIncrementStrategy returns null when both versions are missing`() {
        val parameters = emptyMap<String, String>()

        val result = parser.parseVersionIncrementStrategy(parameters)

        assertThat(result).isNull()
    }
}
