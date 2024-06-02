package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.git.api.GitCommandHistoryApi
import java.io.File
import org.gradle.api.Task
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional

interface GitTask : Task {

    @get:Input val gitRootDirectory: Property<File>
    @get:InputFile @get:Optional val sshKeyFile: RegularFileProperty

    @get:Internal val gitCommandHistoryApi: Property<GitCommandHistoryApi>

    fun gitCommandApi(): GitCommandApi {
        return GitCommandApi.create(gitRootDirectory.get(), null, sshKeyFile.asFile.orNull)
    }
}
