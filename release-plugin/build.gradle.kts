plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

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
            id = "com.github.simonhauck.release"
            implementationClass = "com.github.simonhauck.release.plugin.ReleasePlugin"
        }
    }
}
