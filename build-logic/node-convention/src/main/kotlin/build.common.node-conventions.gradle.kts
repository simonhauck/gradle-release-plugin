import com.github.gradle.node.npm.task.NpmTask

plugins { id("com.github.node-gradle.node") }

val nodeDownloadDirectory: Directory = layout.projectDirectory.dir(".cache/nodejs")
val nodeVersion = "20.11.0"

node {
    version.set(nodeVersion)
    download.set(true)
    workDir.set(nodeDownloadDirectory)
    fastNpmInstall.set(true)
}

val prepareEnvTask = tasks.register("prepareEnv")

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
