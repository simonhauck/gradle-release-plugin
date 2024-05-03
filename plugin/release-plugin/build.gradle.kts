plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

dependencies { implementation(libs.ztExec) }

gradlePlugin {
    plugins {
        create("semantic-versioning") {
            id = "com.github.simonhauck.semantic-versioning"
            implementationClass = "com.github.simonhauck.release.GradleSemanticVersioningPlugin"
        }
    }
}
