import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions")
    id("build.common.artifactory")

    // You would have to additionally specify the version
    id("io.github.simonhauck.release")
}

val versionFile = layout.projectDirectory.file("version.properties")

// You can set the version from the version.properties file. You can utilize this helper method
version = Version.fromPropertiesFile(versionFile.asFile)

// This is the configuration object
release {
    disablePush = true
    // Here you can specify all the configuration options
    // ...
}
