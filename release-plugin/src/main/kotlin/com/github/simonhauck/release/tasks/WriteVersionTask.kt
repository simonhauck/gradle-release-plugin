package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.version.VersionHolderApi
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class WriteVersionTask : BaseReleaseTask() {

    @get:Input abstract val versionType: Property<VersionType>
    @get:Internal abstract val versionHolderApi: Property<VersionHolderApi>
    @get:OutputFile abstract val versionFile: RegularFileProperty

    init {
        description = "Write the new version to the version file"
    }

    @Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
    @TaskAction
    fun action() {
        when (versionType.get()) {
            VersionType.RELEASE ->
                versionHolderApi.get().writeReleaseVersion(versionFile.get().asFile)
            VersionType.NEXT_DEV ->
                versionHolderApi.get().writeNextVersion(versionFile.get().asFile)
        }
    }
}

enum class VersionType {
    RELEASE,
    NEXT_DEV
}
