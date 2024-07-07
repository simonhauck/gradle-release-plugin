pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Specify toolchains: https://github.com/gradle/foojay-toolchains
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}


includeBuild("build-logic")

includeBuild("release-plugin")

include(
    "example",
)

rootProject.name = "gradle-release-plugin"
