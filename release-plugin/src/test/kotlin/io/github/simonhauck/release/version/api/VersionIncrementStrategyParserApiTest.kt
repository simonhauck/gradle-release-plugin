package io.github.simonhauck.release.version.api

import org.assertj.core.api.Assertions.assertThat
import org.gradle.api.GradleException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class VersionIncrementStrategyParserApiTest {

    private val versionIncrementStrategyParserApi = VersionIncrementStrategyParserApi.create()

    @Test
    fun `should throw if no valid arguments are supplied`() {
        val parameters = emptyMap<String, String>()

        val exception =
            assertThrows<GradleException> {
                versionIncrementStrategyParserApi.parseOrThrow(Version("1.0.0"), parameters)
            }

        assertThat(exception.message).isEqualTo("No valid version increment strategy found.")
    }
    // TODO Simon.Hauck 2024-05-11 - add missing tests
}
