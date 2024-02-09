plugins { alias(libs.plugins.openApiGenerator) }

val generateApiBaseDir = "generated/typescript-fetch"

openApiGenerate {
    generatorName.set("typescript-fetch")
    inputSpec.set(layout.projectDirectory.file("src/main/resources/openapi.json").asFile.path)
    outputDir.set(layout.buildDirectory.dir(generateApiBaseDir).get().asFile.path)
    cleanupOutput = true
    configOptions.set(
        mapOf("npmName" to "@server/api", "npmVersion" to "1.0.0", "supportsES6" to "true")
    )
}

tasks.register<Delete>("clean") { delete(layout.buildDirectory) }

val zipTypeScriptFetchApiTask =
    tasks.register<Zip>("zipTypeScriptFetchApi") {
        dependsOn(tasks.openApiGenerate)
        from(layout.buildDirectory.dir("$generateApiBaseDir/src"))
        destinationDirectory.set(layout.buildDirectory.dir("zip"))
        archiveBaseName.set("typescript-fetch-client")
    }

tasks.register("assemble") { dependsOn(zipTypeScriptFetchApiTask) }

configurations.create("typescript-fetch").let {
    artifacts.add(it.name, zipTypeScriptFetchApiTask.get())
}
