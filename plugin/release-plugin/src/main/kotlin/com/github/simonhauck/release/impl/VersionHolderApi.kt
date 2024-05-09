package com.github.simonhauck.release.impl

import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

private val log = KotlinLogging.logger {}

interface VersionHolderApi {

    fun setVersions(
        versionFile: File,
        originalVersion: String,
        releaseVersion: String,
        nextDevelopmentVersion: String
    )

    fun writeReleaseVersion()

    fun writeNextVersion()
}

internal abstract class VersionHolder :
    BuildService<BuildServiceParameters.None>, VersionHolderApi {
    private var versions: Versions? = null

    override fun setVersions(
        versionFile: File,
        originalVersion: String,
        releaseVersion: String,
        nextDevelopmentVersion: String
    ) {
        versions = Versions(versionFile, originalVersion, releaseVersion, nextDevelopmentVersion)
    }

    override fun writeReleaseVersion() {
        writeToFile { it.releaseVersion }
    }

    override fun writeNextVersion() {
        writeToFile { it.nextVersion }
    }

    private fun writeToFile(getVersionFn: (Versions) -> String) {
        val versions = versions ?: throwException()
        val versionToWrite = getVersionFn(versions)
        val file = versions.file

        log.info { "Writing version '$versionToWrite' in ${file.absolutePath}" }
        file.writeText(versionToWrite)
    }

    private fun throwException(): Nothing {
        throw IllegalStateException(
            "Versions not set. Did you execute the CalculateReleaseVersionTask?"
        )
    }
}

internal data class Versions(
    val file: File,
    val originalVersion: String,
    val releaseVersion: String,
    val nextVersion: String,
)
