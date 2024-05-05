package com.github.simonhauck.git

import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.wrapper.GitCommandApi
import com.github.simonhauck.git.wrapper.GitCommandProcessWrapper
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

abstract class BaseGitTask : DefaultTask() {

    @get:Input @get:Optional abstract val processConfig: Property<ProcessConfig>

    init {
        group = "git"
    }

    fun getGitCommandApi(): GitCommandApi {
        return GitCommandProcessWrapper(config = processConfig.getOrElse(ProcessConfig()))
    }
}
