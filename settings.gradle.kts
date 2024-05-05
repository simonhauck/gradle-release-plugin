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

buildCache { local { removeUnusedEntriesAfterDays = 10 } }

includeBuild("build-logic")

includeBuild("plugin")

include(
    "example",
)

rootProject.name = "gradle-semantic-versioning"
