plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

dependencies { implementation(libs.ztExec) }

gradlePlugin {
    plugins {
        create("git-plugin") {
            id = "com.github.simonhauck.git"
            implementationClass = "com.github.simonhauck.git.GitPlugin"
        }
    }
}
