description = "Provides links and tasks related to the maven- and docker-artifactory"

plugins {
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies { implementation(libs.jibPlugin) }
