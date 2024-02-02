import com.github.gradle.node.npm.task.NpmTask

plugins { id("build.common.node-conventions") }

val apiClient: Configuration by configurations.creating {}

dependencies { apiClient(project(":server-api", "typescript-fetch")) }

val syncApiClient =
    tasks.register<Sync>("syncApiClient") {
        dependsOn(apiClient)
        from(zipTree(apiClient.singleFile))
        into("src/lib/generated-server-api")
    }

tasks.prepareEnv { dependsOn(tasks.npmInstall, syncApiClient) }

tasks.register<Delete>("clean") {
    group = "build"
    delete(layout.buildDirectory)
}

tasks.register<NpmTask>("assemble") {
    group = "build"
    dependsOn(tasks.prepareEnv)
    inputs.dir("src")
    inputs.dir("public")
    inputs.files(
        "tsconfig.json",
        "package.json",
        "package-lock.json",
        "next.config.mjs",
        "postcss.config.js",
        "prettierrc.json",
        "tailwind.config.ts"
    )
    outputs.dir(layout.buildDirectory.dir(".next"))
    npmCommand.set(listOf("run", "build"))
}

tasks.register("check") {
    group = "verification"
    dependsOn(tasks.checkFormat)
}
