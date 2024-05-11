package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version

internal sealed interface VersionIncrementStrategy {

    val strategyName: String

    val requiredPropertyDescription: List<String>

    fun tryParse(parameters: Map<String, String>): ReleaseVersions?
}

internal class ManualVersionSelectionStrategy() : VersionIncrementStrategy {
    override val strategyName: String = "Manual Version Selection"

    override val requiredPropertyDescription =
        listOf(
            "$RELEASE_VERSION_KEY - The version to release",
            "$POST_RELEASE_VERSION_KEY - The version after the release"
        )

    override fun tryParse(parameters: Map<String, String>): ReleaseVersions? {
        val releaseVersion = parameters[RELEASE_VERSION_KEY]
        val postReleaseVersion = parameters[POST_RELEASE_VERSION_KEY]

        if (releaseVersion == null || postReleaseVersion == null) {
            return null
        }

        return ReleaseVersions(Version(releaseVersion), Version(postReleaseVersion))
    }

    companion object {
        private const val RELEASE_VERSION_KEY = "releaseVersion"
        private const val POST_RELEASE_VERSION_KEY = "postReleaseVersion"
    }
}
