package io.github.simonhauck.release.version.internal

import arrow.core.Either
import arrow.core.getOrElse
import arrow.core.raise.either
import arrow.core.raise.ensure
import arrow.core.raise.ensureNotNull
import io.github.simonhauck.release.version.api.Version
import org.gradle.api.GradleException

internal data class VersionInfo(
    val major: Int,
    val minor: Int,
    val patch: Int,
    val preReleaseSuffix: String? = null,
    val buildMetaData: String? = null
) {

    fun isPreRelease(): Boolean {
        return preReleaseSuffix != null
    }

    fun toVersion(): Version {
        val preReleaseSuffixString = preReleaseSuffix?.let { "-$preReleaseSuffix" } ?: ""
        val buildMetaDataString = buildMetaData?.let { "+$buildMetaData" } ?: ""
        return Version("$major.$minor.$patch$preReleaseSuffixString$buildMetaDataString")
    }

    fun bumpToRelease(): VersionInfo {
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
            buildMetaData = null
        )
    }

    fun bumpMajor(newPreLeaseSuffix: String? = null): VersionInfo {
        return copy(
            major = major + 1,
            minor = 0,
            patch = 0,
            preReleaseSuffix = newPreLeaseSuffix,
            buildMetaData = null
        )
    }

    companion object {

        fun fromVersion(version: Version): VersionInfo {
            return parseVersionInfo(version).getOrElse { throw it }
        }

        private fun parseVersionInfo(version: Version): Either<GradleException, VersionInfo> =
            either {
                val value = version.value
                val regexString =
                    """^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?${'$'}"""
                val matchEntire = regexString.toRegex().matchEntire(value)

                val matcher = regexString.toPattern().matcher(value)

                val parsingException = buildErrorMessage(version)
                val parseResult = ensureNotNull(matchEntire) { parsingException }
                ensure(matcher.matches()) { parsingException }

                val major = parseResult.groups[1]?.value?.toInt() ?: raise(parsingException)
                val minor = parseResult.groups[2]?.value?.toInt() ?: raise(parsingException)
                val patch = parseResult.groups[3]?.value?.toInt() ?: raise(parsingException)
                val prerelease = parseResult.groups[4]?.value
                val buildMetaData = parseResult.groups[5]?.value

                VersionInfo(major, minor, patch, prerelease, buildMetaData)
            }

        private fun buildErrorMessage(version: Version): GradleException {
            val message =
                "Can not parse versionInfo of '${version.value}' since it does not conform to the SemVer pattern"
            return GradleException(message)
        }
    }
}
