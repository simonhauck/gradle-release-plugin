import io.github.simonhauck.release.tasks.BaseReleaseTask
import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions")
    id("build.common.artifactory")

    // You would have to additionally specify the version
    id("io.github.simonhauck.release")
}

val versionFile = layout.projectDirectory.file("version.properties")

// You can set the version from the version.properties file. You can utilize this helper method
version = Version.fromPropertiesFile(versionFile.asFile)

tasks.withType<BaseReleaseTask> {
    // This is just here, because it interferes with the release task of this parent project
    val include = project.path.startsWith(":example")
    onlyIf { include }
}

// This is the configuration object
release {
    // Here you can specify all the configuration options
    disablePush = true
}
