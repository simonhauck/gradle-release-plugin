package com.github.simonhauck.git.tasks

import com.github.simonhauck.git.GitPluginExtension
import com.github.simonhauck.git.wrapper.GitCommandApi
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal

abstract class BaseGitTask : DefaultTask() {

    @get:Input abstract val gitConfig: Property<GitPluginExtension>

    @get:Internal abstract val commandHistoryApi: Property<CommandHistoryApi>

    init {
        group = "git"
    }

    protected fun gitCommandApi(): GitCommandApi {
        return GitCommandApi.create(
            gitRootDirectory = gitConfig.get().gitRootDirectory.asFile.get()
        )
    }
}
