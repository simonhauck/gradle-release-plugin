package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.version.api.VersionHolderApi
import java.io.File
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class WriteVersionTask : BaseReleaseTask() {

    @get:Input abstract val versionType: Property<VersionType>
    @get:InputFile abstract val releaseVersionStore: RegularFileProperty
    @get:OutputFile abstract val versionFile: RegularFileProperty

    init {
        description = "Write the new version to the version file"
    }

    @Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
    @TaskAction
    fun action() {
        val tmpFileLocation = releaseVersionStore.get().asFile
        val versionHolderApi = VersionHolderApi.create(tmpFileLocation)
        val releaseVersions = versionHolderApi.getReleaseVersionsOrThrow(tmpFileLocation)

        val versionToWrite =
            when (versionType.get()) {
                VersionType.RELEASE -> releaseVersions.releaseVersion
                VersionType.NEXT_DEV -> releaseVersions.postReleaseVersion
            }

        println("$versionToWrite in file ${versionFile.get().asFile.absolutePath}")
        versionHolderApi.writeVersionPropertyToFile(versionFile.get().asFile, versionToWrite)
    }

    private fun VersionHolderApi.getReleaseVersionsOrThrow(tmpFileLocation: File?) =
        loadVersions()
            ?: throw GradleException(
                "No release version found in $tmpFileLocation. Did the task to write the file execute before?"
            )
}

enum class VersionType {
    RELEASE,
    NEXT_DEV
}
