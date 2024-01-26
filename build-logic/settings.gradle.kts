pluginManagement { repositories { gradlePluginPortal() } }

dependencyResolutionManagement {
    versionCatalogs { create("libs") { from(files("../gradle/libs.versions.toml")) } }
}

plugins {
    // Specify toolchains: https://github.com/gradle/foojay-toolchains
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include(
    "artifactory",
    "node-convention",
    "kotlin-convention",
)
