import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions")
    id("build.common.artifactory")

    // You would have to additionally specify the version
    id("io.github.simonhauck.release")
}

version = Version.fromPropertiesFile(layout.projectDirectory.file("version.properties").asFile)

release { versionPropertyFile.set(layout.projectDirectory.file("version.properties")) }
