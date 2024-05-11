package io.github.simonhauck.release.version.api

import io.github.simonhauck.release.version.internal.VersionHolder
import java.io.File

interface VersionHolderApi {

    fun saveVersions(releaseVersions: ReleaseVersions)

    fun loadVersions(): ReleaseVersions?

    fun writeVersionPropertyToFile(file: File, version: Version)

    companion object {
        fun create(tmpFile: File): VersionHolderApi {
            return VersionHolder(tmpFile)
        }
    }
}
