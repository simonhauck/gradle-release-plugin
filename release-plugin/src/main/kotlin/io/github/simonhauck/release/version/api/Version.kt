package io.github.simonhauck.release.version.api

import arrow.core.Either
import arrow.core.getOrElse
import arrow.core.raise.either
import arrow.core.raise.ensure
import arrow.core.raise.ensureNotNull
import io.github.simonhauck.release.file.internal.PropertiesFileUtil
import java.io.File
import org.gradle.api.GradleException

data class Version(
    val value: String,
) {

    fun getVersionInforOrThrow(): VersionInfo {
        return parseVersionInfo().getOrElse { throw it }
    }

    private fun parseVersionInfo(): Either<GradleException, VersionInfo> = either {
        val regexString =
            """^(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?${'$'}"""
        val matchEntire = regexString.toRegex().matchEntire(value)

        val matcher = regexString.toPattern().matcher(value)

        val parseResult = ensureNotNull(matchEntire) { buildErrorMessage() }
        ensure(matcher.matches()) { buildErrorMessage() }

        val major = parseResult.groups[1]?.value?.toInt() ?: raise(buildErrorMessage())
        val minor = parseResult.groups[2]?.value?.toInt() ?: raise(buildErrorMessage())
        val patch = parseResult.groups[3]?.value?.toInt() ?: raise(buildErrorMessage())
        val prerelease = parseResult.groups[4]?.value
        val buildMetaData = parseResult.groups[5]?.value

        VersionInfo(major, minor, patch, prerelease, buildMetaData)
    }

    private fun buildErrorMessage(details: String? = null): GradleException {
        val baseMessage =
            "Can not parse versionInfo of '$value' since it does not conform to the SemVer pattern"
        val message = listOfNotNull(baseMessage, details).joinToString(". ")
        return GradleException(message)
    }

    companion object {
        fun fromPropertiesFile(file: File): String {
            val properties = PropertiesFileUtil().readProperties(file)
            return properties["version"]
                ?: throw GradleException("The version property is missing in the file: $file")
        }
    }
}

data class VersionInfo(
    val majorVersion: Int,
    val minorVersion: Int,
    val patchVersion: Int,
    val preReleaseSuffix: String? = null,
    val buildMetaData: String? = null
)

data class ReleaseVersions(
    val releaseVersion: Version,
    val postReleaseVersion: Version,
)
