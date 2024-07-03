package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version

internal sealed interface VersionIncrementStrategy {

    val strategyName: String

    val requiredPropertyDescription: List<String>

    fun tryParse(currentVersion: Version, parameters: Map<String, String>): ReleaseVersions?
}

internal class ManualVersionSelectionStrategy() : VersionIncrementStrategy {
    override val strategyName: String = "Manual Version Selection"

    override val requiredPropertyDescription =
        listOf(
            "$RELEASE_VERSION_KEY - The version to release",
            "$POST_RELEASE_VERSION_KEY - The version after the release",
        )

    override fun tryParse(
        currentVersion: Version,
        parameters: Map<String, String>
    ): ReleaseVersions? {
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

internal class ReleaseTypeSelectionStrategy : VersionIncrementStrategy {
    override val strategyName: String
        get() = "ReleaseType selection"

    override val requiredPropertyDescription: List<String>
        get() = listOf("$RELEASE_TYPE - The type of release ($MAJOR_KEY, $MINOR_KEY, $PATCH_KEY)")

    override fun tryParse(
        currentVersion: Version,
        parameters: Map<String, String>
    ): ReleaseVersions? {
        val releaseType = parameters[RELEASE_TYPE] ?: return null

        val versionInfo = VersionInfo.fromVersion(currentVersion)

        val releaseVersion =
            when (releaseType) {
                "major" -> versionInfo.bumpMajor()
                "minor" -> versionInfo.bumpMinor()
                "patch" ->
                    if (versionInfo.isPreRelease()) versionInfo.bumpToRelease()
                    else versionInfo.bumpPatch()
                else -> return null
            }

        val postReleaseVersion = releaseVersion.bumpPatch("SNAPSHOT")

        return ReleaseVersions(releaseVersion.toVersion(), postReleaseVersion.toVersion())
    }

    companion object {
        private const val RELEASE_TYPE = "releaseType"
        private const val MAJOR_KEY = "major"
        private const val MINOR_KEY = "minor"
        private const val PATCH_KEY = "patch"
    }
}
