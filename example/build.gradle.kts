import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions")

    // You would have to additionally specify the version
    id("io.github.simonhauck.release")
}

// You can specify a custom version file or place the version the gradle.properties
val gradleFile = rootProject.file("gradle.properties")

// You can set the version from the version.properties file. You can utilize this helper method
version = Version.fromPropertiesFile(gradleFile)

// This is the configuration object
release {
    disablePush = true
    // Here you can specify all the configuration options
    // ...
}
