import com.github.gradle.node.npm.task.NpmTask

plugins { id("build.common.node-conventions") }

val apiClient: Configuration by configurations.creating {}

dependencies { apiClient(project(":server-api", "typescript-fetch")) }

val syncApiClient =
    tasks.register<Sync>("syncApiClient") {
        dependsOn(apiClient)
        from(zipTree(apiClient.singleFile))
        into(layout.projectDirectory.dir("src/lib/generated-server-api"))
    }

tasks.prepareEnv { dependsOn(tasks.npmInstall, syncApiClient) }

tasks.register<Delete>("clean") {
    group = "build"
    delete(layout.buildDirectory, layout.projectDirectory.dir(".next"))
}

tasks.register<NpmTask>("assemble") {
    group = "build"
    dependsOn(tasks.prepareEnv)
    npmCommand.set(listOf("run", "build"))
}

tasks.register("check") {
    group = "verification"
    dependsOn(tasks.checkFormat)
}
