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
