package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version

internal class ReleaseTypeSelectionStrategy(gitCommandApi: GitCommandApi) :
    VersionIncrementStrategy {
    override val strategyName: String
        get() = "ReleaseType selection"

    override val requiredPropertyDescription: List<String>
        get() =
            listOf(
                "$RELEASE_TYPE - The type of release ($MAJOR_KEY, $MINOR_KEY, $PATCH_KEY)",
                "$PRE_SUFFIX - (Optional) Type of pre-release (e.g. alpha, RC, beta, ...). A counter will be automatically applied.",
            )

    override fun tryParse(
        currentVersion: Version,
        parameters: Map<String, String>,
    ): ReleaseVersions? {
        val releaseType = parameters[RELEASE_TYPE] ?: return null
        val preReleaseSuffix = parameters[PRE_SUFFIX]?.findUnusedSuffix(currentVersion)

        val currentVersionInfo = VersionInfo.fromVersion(currentVersion)

        val releaseVersion =
            when (releaseType) {
                "major" -> currentVersionInfo.bumpMajor(preReleaseSuffix)
                "minor" -> currentVersionInfo.bumpMinor(preReleaseSuffix)
                "patch" ->
                    if (currentVersionInfo.isPreRelease())
                        currentVersionInfo.bumpPreReleaseSuffix(preReleaseSuffix)
                    else currentVersionInfo.bumpPatch(preReleaseSuffix)
                else -> return null
            }

        // If the next version is a pre-release, the post-release version is reverted so that the
        // next release can be triggered with the same level again
        val postReleaseVersion =
            if (preReleaseSuffix == null) releaseVersion.bumpPatch("SNAPSHOT")
            else currentVersionInfo

        return ReleaseVersions(releaseVersion.toVersion(), postReleaseVersion.toVersion())
    }

    private fun String.findUnusedSuffix(currentVersion: Version): String {
        return this
    }

    companion object {
        private const val RELEASE_TYPE = "releaseType"
        private const val PRE_SUFFIX = "preReleaseType"
        private const val MAJOR_KEY = "major"
        private const val MINOR_KEY = "minor"
        private const val PATCH_KEY = "patch"
    }
}
