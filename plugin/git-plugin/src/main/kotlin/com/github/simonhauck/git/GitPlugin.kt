package com.github.simonhauck.git

import org.gradle.api.Plugin
import org.gradle.api.Project

class GitPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val config = createConfigWithDefaultValues(project)

        project.tasks.withType(BaseGitTask::class.java) { it.gitConfig.set(config) }
    }

    private fun createConfigWithDefaultValues(project: Project): GitPluginExtension {
        val config = project.extensions.create("gitConfig", GitPluginExtension::class.java)
        config.gitRootDirectory.convention { project.projectDir }
        return config
    }
}
