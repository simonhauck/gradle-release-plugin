package com.github.simonhauck.git

import com.github.simonhauck.git.tasks.BaseGitTask
import com.github.simonhauck.git.tasks.CommandHistoryService
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider

class GitPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val config = project.createConfigWithDefaultValues()

        val commandHistoryService = project.registerCommandService()

        project.tasks.withType(BaseGitTask::class.java) {
            it.gitConfig.set(config)
            it.commandHistoryApi.set(commandHistoryService)
        }
    }

    private fun Project.registerCommandService(): Provider<CommandHistoryService> =
        gradle.sharedServices.registerIfAbsent("commandHistory", CommandHistoryService::class.java)

    private fun Project.createConfigWithDefaultValues(): GitPluginExtension {
        val config = extensions.create("gitConfig", GitPluginExtension::class.java)
        config.gitRootDirectory.convention { projectDir }
        return config
    }
}
