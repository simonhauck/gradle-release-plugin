package io.github.simonhauck.release.version.api

import io.github.simonhauck.release.file.internal.PropertiesFileUtil
import java.io.File
import org.gradle.api.GradleException

data class Version(
    val value: String,
) {

    companion object {
        fun fromPropertiesFile(file: File): String {
            val properties = PropertiesFileUtil().readProperties(file)
            return properties["version"]
                ?: throw GradleException("The version property is missing in the file: $file")
        }
    }
}

data class ReleaseVersions(
    val releaseVersion: Version,
    val postReleaseVersion: Version,
)
