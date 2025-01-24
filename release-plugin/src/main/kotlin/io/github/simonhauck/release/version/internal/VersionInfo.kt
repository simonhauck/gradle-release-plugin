package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.util.Either
import io.github.simonhauck.release.util.getOrElse
import io.github.simonhauck.release.version.api.Version
import org.gradle.api.GradleException

internal data class VersionInfo(
    val major: Int,
    val minor: Int,
    val patch: Int,
    val preReleaseSuffix: String? = null,
    val buildMetaData: String? = null,
) {

    fun isPreRelease(): Boolean {
        return preReleaseSuffix != null
    }

    fun toVersion(): Version {
        val preReleaseSuffixString = preReleaseSuffix?.let { "-$preReleaseSuffix" } ?: ""
        val buildMetaDataString = buildMetaData?.let { "+$buildMetaData" } ?: ""
        return Version("$major.$minor.$patch$preReleaseSuffixString$buildMetaDataString")
    }

    fun dropPreReleaseSuffix(): VersionInfo {
        return copy(preReleaseSuffix = null, buildMetaData = null)
    }

    fun bumpPatch(newPreLeaseSuffix: String? = null): VersionInfo {
        return copy(patch = patch + 1, preReleaseSuffix = newPreLeaseSuffix, buildMetaData = null)
    }

    fun bumpMinor(newPreLeaseSuffix: String? = null): VersionInfo {
        return copy(
            minor = minor + 1,
            patch = 0,
            preReleaseSuffix = newPreLeaseSuffix,
            buildMetaData = null,
        )
    }

    fun bumpMajor(newPreLeaseSuffix: String? = null): VersionInfo {
        return copy(
            major = major + 1,
            minor = 0,
            patch = 0,
            preReleaseSuffix = newPreLeaseSuffix,
            buildMetaData = null,
        )
    }

    companion object {

        fun fromVersion(version: Version): VersionInfo {
            return parseVersionInfo(version).getOrElse { throw it }
        }

        private fun parseVersionInfo(version: Version): Either<GradleException, VersionInfo> {
            val value = version.value
            val regexString =
                """^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?${'$'}"""
            val matchEntire = regexString.toRegex().matchEntire(value)
            val matcher = regexString.toPattern().matcher(value)

            val parsingException = buildErrorMessage(version)
            if (matchEntire == null || !matcher.matches()) {
                return Either.Left(parsingException)
            }

            val major = matchEntire.groups[1]?.value?.toIntOrNull()
            val minor = matchEntire.groups[2]?.value?.toIntOrNull()
            val patch = matchEntire.groups[3]?.value?.toIntOrNull()
            val prerelease = matchEntire.groups[4]?.value
            val buildMetaData = matchEntire.groups[5]?.value

            if (major == null || minor == null || patch == null) {
                return Either.Left(parsingException)
            }

            return Either.Right(VersionInfo(major, minor, patch, prerelease, buildMetaData))
        }

        private fun buildErrorMessage(version: Version): GradleException {
            val message =
                "Can not parse versionInfo of '${version.value}' since it does not conform to the SemVer pattern"
            return GradleException(message)
        }
    }
}
