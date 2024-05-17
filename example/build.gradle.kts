import io.github.simonhauck.release.tasks.BaseReleaseTask
import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.kotlin-conventions")
    id("build.common.artifactory")

    // You would have to additionally specify the version
    id("io.github.simonhauck.release")
}

// This is just here, because it interferes with the release task of this parent project
tasks.withType<BaseReleaseTask>() {
    val inlcude = project.path.startsWith("example")
    onlyIf { inlcude }
}

version = Version.fromPropertiesFile(layout.projectDirectory.file("version.properties").asFile)

release { versionPropertyFile.set(layout.projectDirectory.file("version.properties")) }
