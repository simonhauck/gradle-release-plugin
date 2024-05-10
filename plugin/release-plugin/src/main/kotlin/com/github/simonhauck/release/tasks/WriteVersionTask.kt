package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.impl.VersionHolderApi
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class WriteVersionTask : DefaultTask() {

    @get:Input abstract val versionType: Property<VersionType>
    @get:Internal abstract val versionHolderApi: Property<VersionHolderApi>
    @get:OutputFile abstract val versionFile: RegularFileProperty

    init {
        group = "release"
        description = "Write the new version to the version file"
    }

    @TaskAction
    fun action() {
        when (versionType.get()) {
            VersionType.RELEASE ->
                versionHolderApi.get().writeReleaseVersion(versionFile.get().asFile)
            VersionType.NEXT_DEV ->
                versionHolderApi.get().writeNextVersion(versionFile.get().asFile)
            else -> throw IllegalStateException("This should not happen. VersionType is null...")
        }
    }
}

enum class VersionType {
    RELEASE,
    NEXT_DEV
}
