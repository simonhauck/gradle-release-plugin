package io.github.simonhauck.release.version.internal

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionHolderApi
import java.io.File
import java.util.*

private val log = KotlinLogging.logger {}

internal class VersionHolder(private val tmpFileLocation: File) : VersionHolderApi {

    override fun saveVersions(releaseVersions: ReleaseVersions) {
        log.info { "Saving versions to ${tmpFileLocation.absolutePath} to $releaseVersions" }

        Properties().apply {
            setProperty(RELEASE_VERSION_KEY, releaseVersions.releaseVersion.version)
            setProperty(POST_RELEASE_VERSION_KEY, releaseVersions.postReleaseVersion.version)
            writeToFile(tmpFileLocation)
        }
    }

    override fun loadVersions(): ReleaseVersions? {
        log.debug { "Loading release versions from ${tmpFileLocation.absolutePath}" }

        val properties = readPropertiesFile(tmpFileLocation)

        val releaseVersion = properties.getProperty(RELEASE_VERSION_KEY) ?: return null
        val postReleaseVersion = properties.getProperty(POST_RELEASE_VERSION_KEY) ?: return null
        return ReleaseVersions(Version(releaseVersion), Version(postReleaseVersion))
    }

    override fun writeVersionPropertyToFile(file: File, version: Version) {
        readPropertiesFile(file).apply {
            setProperty("version", version.version)
            writeToFile(file)
        }
    }

    private fun Properties.writeToFile(file: File) {
        val content =
            map { (key, value) -> "$key=$value" }.sorted().joinToString(System.lineSeparator())

        file.writeText(content)
    }

    private fun readPropertiesFile(file: File): Properties {
        return Properties().apply { file.inputStream().use { load(it) } }
    }

    companion object {
        private const val RELEASE_VERSION_KEY = "releaseVersion"
        private const val POST_RELEASE_VERSION_KEY = "postReleaseVersion"
    }
}
