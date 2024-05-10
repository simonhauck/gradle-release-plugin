package com.github.simonhauck.release

import com.github.simonhauck.release.impl.VersionHolder
import com.github.simonhauck.release.tasks.CalculateReleaseVersionTask
import com.github.simonhauck.release.tasks.VersionType
import com.github.simonhauck.release.tasks.WriteVersionTask
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider

class ReleasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.registerExtension()

        val versionHolderProvider = project.registerVersionHolderService()

        project.tasks.withType(CalculateReleaseVersionTask::class.java) {
            it.versionHolder.set(versionHolderProvider)
        }

        val calculateReleaseVersionTask =
            project.tasks.register(
                "calculateReleaseVersion",
                CalculateReleaseVersionTask::class.java
            ) {
                val stringMap =
                    project.properties.map { (key, value) -> key to value.toString() }.toMap()
                it.commandLineParameters.set(stringMap)
                it.versionPropertyFile.set(extension.versionPropertyFile)
            }

        project.tasks.withType(WriteVersionTask::class.java) {
            it.versionHolderApi.set(versionHolderProvider)
        }

        val writeReleaseVersionTask =
            project.tasks.register("writeReleaseVersion", WriteVersionTask::class.java) {
                it.dependsOn(calculateReleaseVersionTask)
                it.versionType.set(VersionType.RELEASE)
                it.versionHolderApi.set(versionHolderProvider)
                it.versionFile.set(extension.versionPropertyFile)
            }

        val writeNextDevVersionTask =
            project.tasks.register("writeNextDevVersion", WriteVersionTask::class.java) {
                // TODO Simon.Hauck 2024-05-10 - remove this temporary dependency to
                // writeReleaseVersionTask
                it.dependsOn(calculateReleaseVersionTask, writeReleaseVersionTask)
                it.versionType.set(VersionType.NEXT_DEV)
                it.versionHolderApi.set(versionHolderProvider)
                it.versionFile.set(extension.versionPropertyFile)
            }

        project.tasks.register("release", DefaultTask::class.java) {
            it.group = "release"
            it.description = "Release the current version"
            it.dependsOn(writeNextDevVersionTask)
        }
    }

    private fun Project.registerExtension(): ReleaseExtension {
        val extension =
            extensions.create("semanticVersioning", ReleaseExtension::class.java)

        extension.versionPropertyFile.convention(layout.projectDirectory.file("version.properties"))
        extension.rootGitDirectory.convention(layout.projectDirectory.file("./"))
        extension.releaseBranchName.convention("main")

        return extension
    }

    private fun Project.registerVersionHolderService(): Provider<VersionHolder> =
        gradle.sharedServices.registerIfAbsent("versionHolder", VersionHolder::class.java)
}
