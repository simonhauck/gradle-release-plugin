import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins { alias(libs.plugins.openApiGenerator) }

openApiGenerate {
    generatorName.set("typescript-fetch")
    inputSpec.set(layout.projectDirectory.file("src/main/resources/openapi.json").asFile.path)
    outputDir.set(layout.buildDirectory.dir("generated/typescript-fetch").map { it.asFile.path })

    configOptions.set(
        mapOf("npmName" to "@server/api", "npmVersion" to "1.0.0", "supportsES6" to "true")
    )
}

tasks.register("clean") { delete(layout.buildDirectory) }

val deleteGeneratedCodeTask =
    tasks.register<Delete>("cleanApiGeneratedPackages") {
        delete(layout.buildDirectory.dir("generated/typescript-fetch/*"))
    }

val generateApiBindingTask = tasks.withType<GenerateTask> { dependsOn(deleteGeneratedCodeTask) }

val zipTypeScriptFetchApiTask =
    tasks.register<Zip>("zipTypeScriptFetchApi") {
        dependsOn(generateApiBindingTask)
        from(layout.buildDirectory.dir("generated/typescript-fetch/src"))
        destinationDirectory.set(layout.buildDirectory.dir("zip"))
        archiveBaseName.set("typescript-fetch-client")
    }

tasks.register("assemble") { dependsOn(zipTypeScriptFetchApiTask) }

configurations.create("typescript-fetch").let {
    artifacts.add(it.name, zipTypeScriptFetchApiTask.get())
}
