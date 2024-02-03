import com.github.gradle.node.npm.task.NpmTask

plugins { id("com.github.node-gradle.node") }

val nodeDownloadDirectory: Provider<Directory> = layout.buildDirectory.dir(".cache/nodejs")
val nodeVersion = "20.11.0"

node {
    version.set(nodeVersion)
    download.set(true)
    workDir.set(nodeDownloadDirectory)
    fastNpmInstall.set(true)
}

tasks.npmInstall {
    inputs.file("package.json")
    outputs.files("package-lock.json", "node_modules/.package-lock.json")
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
        outputs.dir("src")

        npmCommand.set(listOf("run", "lint"))
    }
