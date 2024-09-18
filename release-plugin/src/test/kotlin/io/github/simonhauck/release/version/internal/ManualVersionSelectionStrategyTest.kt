package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ManualVersionSelectionStrategyTest {

    private val manualVersionSelectionStrategy = ManualVersionSelectionStrategy()

    @Test
    fun getStrategyName() {
        val actual = manualVersionSelectionStrategy.strategyName

        assertThat(actual).isEqualTo("Manual Version Selection")
    }

    @Test
    fun getRequiredPropertyDescription() {
        val actual = manualVersionSelectionStrategy.requiredPropertyDescription

        assertThat(actual)
            .containsExactly(
                "releaseVersion - The version to release",
                "postReleaseVersion - The version after the release",
            )
    }

    @Test
    fun `should return the release and postRelease version if they are specified as parameters`() {

        val parameters =
            mapOf("releaseVersion" to "1.1.0", "postReleaseVersion" to "1.2.0-SNAPSHOT")

        val actual = manualVersionSelectionStrategy.tryParse(Version("1.0.0"), parameters)

        assertThat(actual).isEqualTo(ReleaseVersions(Version("1.1.0"), Version("1.2.0-SNAPSHOT")))
    }

    @Test
    fun `should return null of one key is missing`() {
        val parameters = mapOf("releaseVersion" to "1.1.0")

        val actual = manualVersionSelectionStrategy.tryParse(Version("1.0.0"), parameters)

        assertThat(actual).isNull()
    }
}
