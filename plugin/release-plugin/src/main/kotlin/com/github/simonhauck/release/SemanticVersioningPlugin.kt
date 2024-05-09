package com.github.simonhauck.release

import com.github.simonhauck.release.impl.VersionHolder
import com.github.simonhauck.release.tasks.CalculateReleaseVersionTask
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Provider

class SemanticVersioningPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.registerExtension()

        val versionHolderProvider = project.registerVersionHolderService()

        val calculateReleaseVersionTask =
            project.tasks.register(
                "calculateReleaseVersion",
                CalculateReleaseVersionTask::class.java
            ) {
                it.versionHolder.set(versionHolderProvider)
                it.commandLineParameters.set(
                    project.properties.mapValues { value -> value.toString() }
                )
                it.versionPropertyFile.set(extension.versionPropertyFile)
            }

        project.tasks.register("release", DefaultTask::class.java) {
            it.group = "release"
            it.description = "Release the current version"
            it.dependsOn(calculateReleaseVersionTask)
        }
    }

    private fun Project.registerExtension(): SemanticVersioningExtension {
        val extension =
            extensions.create("semanticVersioning", SemanticVersioningExtension::class.java)

        extension.versionPropertyFile.convention(layout.projectDirectory.file("version.properties"))
        extension.rootGitDirectory.convention(layout.projectDirectory.file("./"))
        extension.releaseBranchName.convention("main")

        return extension
    }

    private fun Project.registerVersionHolderService(): Provider<VersionHolder> =
        gradle.sharedServices.registerIfAbsent("versionHolder", VersionHolder::class.java)
}
