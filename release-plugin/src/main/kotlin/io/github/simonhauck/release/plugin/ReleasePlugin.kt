package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.git.internal.commands.GitGitCommandHistoryService
import io.github.simonhauck.release.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider

class ReleasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.registerExtension()
        project.configureBaseReleaseTask(extension)

        val commandHistoryService = project.registerGitHistoryService()

        val releaseVersionStore =
            project.layout.buildDirectory.file("release/tmpVersion.properties")

        val calculateReleaseVersionTask =
            project.registerCalculateReleaseVersionTask(releaseVersionStore, extension)

        val writeReleaseVersionTask =
            project.tasks.register("writeReleaseVersion", WriteVersionTask::class.java) {
                it.dependsOn(calculateReleaseVersionTask)
                it.versionType.set(VersionType.RELEASE)
                it.releaseVersionStore.set(releaseVersionStore)
                it.versionFile.set(extension.versionPropertyFile)
            }

        val writeNextDevVersionTask =
            project.tasks.register("writeNextDevVersion", WriteVersionTask::class.java) {
                // TODO Simon.Hauck 2024-05-10 - remove this temporary dependency to
                // writeReleaseVersionTask
                it.dependsOn(calculateReleaseVersionTask, writeReleaseVersionTask)
                it.versionType.set(VersionType.NEXT_DEV)
                it.releaseVersionStore.set(releaseVersionStore)
                it.versionFile.set(extension.versionPropertyFile)
            }

        project.tasks.withType(CommitAndTagTask::class.java) {
            it.gitCommandHistoryApi.set(commandHistoryService)
        }

        project.tasks.withType(CreateBranchTask::class.java) {
            it.gitCommandHistoryApi.set(commandHistoryService)
        }

        project.tasks.register("release", BaseReleaseTask::class.java) {
            it.description = "Release the current version"
            it.dependsOn(writeNextDevVersionTask)
        }
    }

    private fun Project.registerCalculateReleaseVersionTask(
        releaseVersionStore: Provider<RegularFile>,
        extension: ReleaseExtension
    ): TaskProvider<CalculateReleaseVersionTask> =
        tasks.register("calculateReleaseVersion", CalculateReleaseVersionTask::class.java) {
            val stringMap = properties.map { (key, value) -> key to value.toString() }.toMap()
            it.commandLineParameters.set(stringMap)
            it.releaseVersionStorePath.set(releaseVersionStore.get().asFile)
            it.versionPropertyFile.set(extension.versionPropertyFile)
            it.releaseVersionStore.set(releaseVersionStore)
        }

    private fun Project.configureBaseReleaseTask(extension: ReleaseExtension) {
        tasks.withType(BaseReleaseTask::class.java) {
            it.gitRootDirectory.set(extension.rootGitDirectory.asFile)
        }
    }

    private fun Project.registerExtension(): ReleaseExtension {
        val extension = extensions.create("release", ReleaseExtension::class.java)

        return extension
    }

    private fun Project.registerGitHistoryService(): Provider<GitGitCommandHistoryService> =
        gradle.sharedServices.registerIfAbsent(
            "commandHistory",
            GitGitCommandHistoryService::class.java
        )
}
