package com.github.simonhauck.git

import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.wrapper.GitCommandApi
import com.github.simonhauck.git.wrapper.GitCommandProcessWrapper
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input

abstract class BaseGitTask : DefaultTask() {

    @get:Input abstract val gitConfig: Property<GitPluginExtension>

    init {
        group = "git"
    }

    protected fun gitCommandApi(): GitCommandApi {
        return GitCommandProcessWrapper(config = gitConfig.get().mapToProcessConfig())
    }

    private fun GitPluginExtension.mapToProcessConfig(): ProcessConfig {
        return ProcessConfig(workingDir = gitRootDirectory.get().asFile)
    }
}