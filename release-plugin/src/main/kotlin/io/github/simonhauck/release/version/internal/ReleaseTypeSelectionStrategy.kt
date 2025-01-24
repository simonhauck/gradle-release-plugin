package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.git.api.GitError
import io.github.simonhauck.release.util.Either
import io.github.simonhauck.release.util.flatten
import io.github.simonhauck.release.util.getOrNull
import io.github.simonhauck.release.util.map
import io.github.simonhauck.release.util.onLeft
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import org.gradle.api.logging.Logging

internal class ReleaseTypeSelectionStrategy(
    private val gitCommandApi: GitCommandApi,
    private val releaseTagName: String,
) : VersionIncrementStrategy {

    private val log = Logging.getLogger(ReleaseTypeSelectionStrategy::class.java)

    override val strategyName: String
        get() = "ReleaseType selection"

    override val requiredPropertyDescription: List<String>
        get() =
            listOf(
                "$RELEASE_TYPE - The type of release ($MAJOR_KEY, $MINOR_KEY, $PATCH_KEY)",
                "$PRE_RELEASE_TYPE - (Optional) Type of pre-release (e.g. alpha, RC, beta, ...). A counter will be automatically applied.",
            )

    override fun tryParse(
        currentVersion: Version,
        parameters: Map<String, String>,
    ): ReleaseVersions? {
        val releaseType = parameters[RELEASE_TYPE] ?: return null
        val preReleaseType = parameters[PRE_RELEASE_TYPE]

        val currentVersionInfo = VersionInfo.fromVersion(currentVersion)

        val releaseVersion =
            when (releaseType) {
                "major" -> currentVersionInfo.bumpMajor(preReleaseType)
                "minor" -> currentVersionInfo.bumpMinor(preReleaseType)
                "patch" ->
                    if (currentVersionInfo.isPreRelease()) currentVersionInfo.dropPreReleaseSuffix()
                    else currentVersionInfo.bumpPatch(preReleaseType)
                else -> return null
            }.applyPreReleaseTypeIfAvailable(preReleaseType)

        // If the next version is a pre-release, the post-release version is reverted so that the
        // next release can be triggered with the same level again
        val postReleaseVersion =
            if (preReleaseType == null) releaseVersion.bumpPatch("SNAPSHOT") else currentVersionInfo

        return ReleaseVersions(releaseVersion.toVersion(), postReleaseVersion.toVersion())
    }

    private fun VersionInfo.applyPreReleaseTypeIfAvailable(preReleaseSuffix: String?): VersionInfo {
        if (preReleaseSuffix == null) return this

        val tags =
            gitCommandApi
                .fetchRemoteTags()
                .map { gitCommandApi.listTags() }
                .flatten()
                .logErrorOnLeft()
                .getOrNull()
                ?.toSet() ?: return this

        return generateSequence(1) { it + 1 }
            .map { index -> this.copy(preReleaseSuffix = "$preReleaseSuffix$index") }
            .first { version -> !tags.containsVersion(version) }
    }

    private fun Set<String>.containsVersion(version: VersionInfo): Boolean {
        val expectedReleaseTag = releaseTagName.replace("{version}", version.toVersion().value)
        return contains(expectedReleaseTag)
    }

    private fun <B> Either<GitError, B>.logErrorOnLeft(): Either<GitError, B> = onLeft {
        log.info("Failed to get all local and remote tags - This will not fail the build")
        log.info(it.message)
    }

    companion object {
        private const val RELEASE_TYPE = "releaseType"
        private const val PRE_RELEASE_TYPE = "preReleaseType"
        private const val MAJOR_KEY = "major"
        private const val MINOR_KEY = "minor"
        private const val PATCH_KEY = "patch"
    }
}
