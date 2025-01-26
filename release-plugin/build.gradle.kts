import java.util.Properties

plugins {
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
    alias(libs.plugins.gradlePublish)
}

group = "io.github.simonhauck.release"

version = readVersionFromFile(rootProject.file("../version.properties"))

dependencies {
    implementation(libs.ztExec)

    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.junit)
    testImplementation(libs.testContainers)
}

@Suppress("UnstableApiUsage")
gradlePlugin {
    website = "https://github.com/simonhauck/gradle-release-plugin"
    vcsUrl = "https://github.com/simonhauck/gradle-release-plugin"
    plugins {
        create("release-plugin") {
            id = "io.github.simonhauck.release"
            displayName = "Release"
            description = "A gradle plugin to automate your releases with Git"
            tags = listOf("release", "git", "automation", "release-automation")
            implementationClass = "io.github.simonhauck.release.plugin.ReleasePlugin"
        }
    }
}

private fun readVersionFromFile(file: File): String = readProperties(file).getProperty("version")

private fun readProperties(propertiesFile: File) =
    Properties().apply { propertiesFile.inputStream().use { load(it) } }
