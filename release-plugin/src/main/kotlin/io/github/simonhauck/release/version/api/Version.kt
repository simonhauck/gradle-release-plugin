package io.github.simonhauck.release.version.api

data class Version(
    val version: String,
)

data class ReleaseVersions(
    val releaseVersion: Version,
    val postReleaseVersion: Version,
)
