import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node")
}

val nodeDownloadDirectory = "${project.projectDir}/.cache/nodejs"
val nodeVersion = "20.11.0"

node {
    version.set(nodeVersion)
    download.set(true)
    workDir.set(file(nodeDownloadDirectory))
    fastNpmInstall.set(true)
}

val prepareEnvTask = tasks.register("prepareEnv")

tasks.npmInstall {
    outputs.upToDateWhen { project.file("/node_modules/.package-lock.json").exists() }
}

// ---------------------------------------------------------------------------------------------------------------------
// Formatting
// ---------------------------------------------------------------------------------------------------------------------

val formatTask =
    tasks.register<NpmTask>("format") {
        group = "formatting"
        dependsOn(prepareEnvTask)

        npmCommand.set(listOf("run", "lint:fix"))
    }

val checkFormatTask =
    tasks.register<NpmTask>("checkFormat") {
        group = "verification"
        dependsOn(prepareEnvTask)

        npmCommand.set(listOf("run", "lint"))
    }

