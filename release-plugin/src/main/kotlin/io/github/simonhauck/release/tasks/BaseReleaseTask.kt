package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitCommandApi
import java.io.File
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input

abstract class BaseReleaseTask : DefaultTask() {
    @get:Input abstract val gitRootDirectory: Property<File>

    init {
        group = "release"
    }

    protected fun gitCommandApi(): GitCommandApi {
        return GitCommandApi.create(gitRootDirectory = gitRootDirectory.get())
    }
}
