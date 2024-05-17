import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions") apply false
    id("io.github.simonhauck.release")
}

allprojects {
    group = "io.github.simonhauck.release"
    version = Version.fromPropertiesFile(rootProject.file("version.properties"))
}

release { disablePush = true }
