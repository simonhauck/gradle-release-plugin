package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.git.api.getOrThrowGradleException
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import org.gradle.api.logging.Logging

internal class ReleaseTypeSelectionStrategy(private val gitCommandApi: GitCommandApi) :
    VersionIncrementStrategy {

    private val log = Logging.getLogger(ReleaseTypeSelectionStrategy::class.java)

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
        val preReleaseSuffix = parameters[PRE_SUFFIX]

        val currentVersionInfo = VersionInfo.fromVersion(currentVersion)

        val releaseVersion =
            when (releaseType) {
                "major" -> currentVersionInfo.bumpMajor(preReleaseSuffix)
                "minor" -> currentVersionInfo.bumpMinor(preReleaseSuffix)
                "patch" ->
                    if (currentVersionInfo.isPreRelease()) currentVersionInfo.dropPreReleaseSuffix()
                    else currentVersionInfo.bumpPatch(preReleaseSuffix)
                else -> return null
            }.applyPreReleaseSuffixIfPresent(preReleaseSuffix)

        // If the next version is a pre-release, the post-release version is reverted so that the
        // next release can be triggered with the same level again
        val postReleaseVersion =
            if (preReleaseSuffix == null) releaseVersion.bumpPatch("SNAPSHOT")
            else currentVersionInfo

        return ReleaseVersions(releaseVersion.toVersion(), postReleaseVersion.toVersion())
    }

    private fun VersionInfo.applyPreReleaseSuffixIfPresent(preReleaseSuffix: String?): VersionInfo {
        if (preReleaseSuffix == null) return this

        val unusedPreReleaseSuffix = preReleaseSuffix.findUnusedSuffix(this)

        return this.copy(preReleaseSuffix = unusedPreReleaseSuffix)
    }

    private fun String.findUnusedSuffix(releaseVersion: VersionInfo): String {
        gitCommandApi.fetchRemoteTags().onLeft {
            log.debug("Failed to fetch remote tags... This will not fail release process.")
            log.debug(it.message)
        }

        val existingTags = gitCommandApi.listTags().getOrThrowGradleException()

        val relevantTags =
            existingTags.filter {
                val version = releaseVersion.copy(preReleaseSuffix = this).toVersion()
                it.startsWith(version.value)
            }

        // TOOD (Simon Hauck): We must pass in the pre release tag as well. to get the correct
        // suffix
        relevantTags.forEachIndexed { index, _ ->
            val newSuffix = "$this.${index + 1}"
            if (!relevantTags.contains(newSuffix)) return newSuffix
        }
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
