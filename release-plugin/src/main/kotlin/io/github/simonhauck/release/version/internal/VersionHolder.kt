package io.github.simonhauck.release.version.internal

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.simonhauck.release.file.internal.PropertiesFileUtil
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionHolderApi
import java.io.File
import java.util.*
import org.gradle.api.GradleException

private val log = KotlinLogging.logger {}

internal class VersionHolder(private val tmpFileLocation: File) : VersionHolderApi {

    override fun saveVersions(releaseVersions: ReleaseVersions) {
        log.info { "Saving versions to ${tmpFileLocation.absolutePath} to $releaseVersions" }

        Properties().apply {
            setProperty(RELEASE_VERSION_KEY, releaseVersions.releaseVersion.value)
            setProperty(POST_RELEASE_VERSION_KEY, releaseVersions.postReleaseVersion.value)
            writeToFile(tmpFileLocation)
        }
    }

    override fun loadVersions(): ReleaseVersions? {
        log.debug { "Loading release versions from ${tmpFileLocation.absolutePath}" }

        val properties = readPropertiesFile(tmpFileLocation)

        val releaseVersion = properties[RELEASE_VERSION_KEY] ?: return null
        val postReleaseVersion = properties[POST_RELEASE_VERSION_KEY] ?: return null
        return ReleaseVersions(Version(releaseVersion), Version(postReleaseVersion))
    }

    override fun writeVersionPropertyToFile(file: File, version: Version) {
        val updatedMap =
            readPropertiesFile(file).toMutableMap().apply {
                put("version", version.value)
                toMap()
            }

        PropertiesFileUtil().writePropertiesFile(file, updatedMap)
    }

    private fun Properties.writeToFile(file: File) {
        val content =
            map { (key, value) -> "$key=$value" }.sorted().joinToString(System.lineSeparator())

        file.writeText(content)
    }

    override fun loadVersionFromFileOrThrow(file: File): Version {
        readPropertiesFile(file).apply {
            val propertyName = "version"
            val version =
                getOrElse(propertyName) {
                    throw GradleException("No '$propertyName' property found in $file")
                }
            return Version(version)
        }
    }

    private fun readPropertiesFile(file: File): Map<String, String> {
        return PropertiesFileUtil().readProperties(file)
    }

    companion object {
        private const val RELEASE_VERSION_KEY = "releaseVersion"
        private const val POST_RELEASE_VERSION_KEY = "postReleaseVersion"
    }
}
