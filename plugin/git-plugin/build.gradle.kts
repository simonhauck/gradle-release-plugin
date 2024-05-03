plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

dependencies {
    implementation(libs.ztExec)

    testImplementation(libs.bundles.junit)
}

gradlePlugin {
    plugins {
        create("git-plugin") {
            id = "com.github.simonhauck.git"
            implementationClass = "com.github.simonhauck.git.GitPlugin"
        }
    }
}
