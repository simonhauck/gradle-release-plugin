import Build_common_lifecycle_gradle.CheckJvmArgsCompatibilityTask
import Build_common_lifecycle_gradle.LifeCycleUtility.dependsOnSameTaskInIncludedBuilds
import Build_common_lifecycle_gradle.LifeCycleUtility.dependsOnSameTaskInSubmodules
import io.github.simonhauck.release.version.api.Version

plugins {
    id("build.common.lifecycle")
    id("build.common.kotlin-conventions") apply false
    id("io.github.simonhauck.release")
}

allprojects {
    group = "io.github.simonhauck.release"
    version = Version.fromPropertiesFile(rootProject.file("version.properties"))
}

// To prevent accidental release commits, a separate property must be set
release {
    disablePush = !project.properties["enablePush"].toString().toBoolean()
    gitName = "Release Bot"
    gitEmail = "no-replay@release-bot.com"
}

// ---------------------------------------------------------------------------------------------------------------------
// Lifecycle
// ---------------------------------------------------------------------------------------------------------------------

val checkJvmArgsCompatibilityTask =
    tasks.register<CheckJvmArgsCompatibilityTask>("checkJvmArgsCompatibility") {
        gradlePropertiesFiles =
            listOf(
                layout.projectDirectory.file("gradle.properties").asFile,
                layout.projectDirectory.file("build-logic/gradle.properties").asFile,
                layout.projectDirectory.file("release-plugin/gradle.properties").asFile,
            )
    }

tasks.check { dependsOn(checkJvmArgsCompatibilityTask) }

listOf(tasks.clean, tasks.check, tasks.assemble, tasks.build).forEach {
    it.dependsOnSameTaskInSubmodules()
    it.dependsOnSameTaskInIncludedBuilds()
}

// ---------------------------------------------------------------------------------------------------------------------
// Formatting tasks
// ---------------------------------------------------------------------------------------------------------------------

tasks.register("format") {
    group = "formatting"
    dependsOnSameTaskInIncludedBuilds(excludedModule = listOf("build-logic"))
}

tasks.register("checkFormat") {
    group = "verification"
    dependsOnSameTaskInSubmodules()
    dependsOnSameTaskInIncludedBuilds(excludedModule = listOf("build-logic"))
}
