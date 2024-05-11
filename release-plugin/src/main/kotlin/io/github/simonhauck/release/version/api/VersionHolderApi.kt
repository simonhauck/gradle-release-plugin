package io.github.simonhauck.release.version.api

import java.io.File

interface VersionHolderApi {

    fun setVersions(
        versionFile: File,
        originalVersion: String,
        releaseVersion: String,
        nextDevelopmentVersion: String
    )

    fun writeReleaseVersion(propertyFile: File)

    fun writeNextVersion(propertyFile: File)
}
