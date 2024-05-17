import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

version = Version.fromPropertiesFile(rootProject.file("version.properties"))

dependencies {
    implementation(libs.ztExec)
    implementation(libs.kotlinLogging)
    implementation(libs.arrowKt)

    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.junit)
}

gradlePlugin {
    plugins {
        create("release-plugin") {
            id = "io.github.simonhauck.release"
            implementationClass = "io.github.simonhauck.release.plugin.ReleasePlugin"
        }
    }
}
