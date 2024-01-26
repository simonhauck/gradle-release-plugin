pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Specify toolchains: https://github.com/gradle/foojay-toolchains
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

buildCache { local { removeUnusedEntriesAfterDays = 10 } }

includeBuild("build-logic")

include("server", "server-api")

rootProject.name =
    "startup-template"
