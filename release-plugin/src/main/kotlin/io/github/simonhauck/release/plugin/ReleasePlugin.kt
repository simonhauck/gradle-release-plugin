package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.git.internal.commands.GitCommandHistoryService
import io.github.simonhauck.release.tasks.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider

class ReleasePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.registerExtension()

        project.configureGitTasks(extension)

        val releaseVersionStore =
            project.layout.buildDirectory.file("release/tmpVersion.properties")

        val calculateReleaseVersionTask =
            project.registerCalculateReleaseVersionTask(releaseVersionStore, extension)

        val writeReleaseVersionTask =
            project.registerWriteReleaseVersionTask(
                calculateReleaseVersionTask,
                releaseVersionStore,
                extension
            )

        val commitReleaseVersion =
            project.registerReleaseCommitTask(writeReleaseVersionTask, extension)

        val writePostReleaseVersionTask =
            project.tasks.register("writePostReleaseVersion", WriteVersionTask::class.java) {
                it.dependsOn(commitReleaseVersion)
                it.versionType.set(VersionType.NEXT_DEV)
                it.releaseVersionStore.set(releaseVersionStore)
                it.versionFile.set(extension.versionPropertyFile)
            }

        val commitPostReleaseVersionTask =
            project.registerPostReleaseCommitTask(writePostReleaseVersionTask, extension)

        project.tasks.register("release", BaseReleaseTask::class.java) {
            it.description = "Release the current version"
            it.dependsOn(commitPostReleaseVersionTask)
        }
    }

    private fun Project.registerReleaseCommitTask(
        writeReleaseVersionTask: TaskProvider<WriteVersionTask>,
        extension: ReleaseExtension,
    ): TaskProvider<CommitAndTagTask> {
        return tasks.register("commitReleaseVersion", CommitAndTagTask::class.java) {
            it.dependsOn(writeReleaseVersionTask)
            it.commitMessage.set(extension.releaseCommitMessage)
            it.commitMessagePrefix.set(extension.commitMessagePrefix)
            it.tagName.set(extension.tagName)
            it.stringTemplateVariables.set(extension.versionPropertyFile)
            it.gitAddFilePattern.set(
                extension.gitAddFiles.map { regularFiles ->
                    regularFiles.map { regularFile -> regularFile.asFile }
                }
            )
        }
    }

    private fun Project.registerPostReleaseCommitTask(
        writePostReleaseVersion: TaskProvider<WriteVersionTask>,
        extension: ReleaseExtension,
    ): TaskProvider<CommitAndTagTask> {
        return tasks.register("commitPostReleaseVersion", CommitAndTagTask::class.java) {
            it.dependsOn(writePostReleaseVersion)
            it.commitMessage.set(extension.postReleaseCommitMessage)
            it.commitMessagePrefix.set(extension.commitMessagePrefix)
            it.stringTemplateVariables.set(extension.versionPropertyFile)
            it.gitAddFilePattern.set(
                extension.versionPropertyFile.map { file -> listOf(file.asFile) }
            )
        }
    }

    private fun Project.registerWriteReleaseVersionTask(
        calculateReleaseVersionTask: TaskProvider<CalculateReleaseVersionTask>,
        releaseVersionStore: Provider<RegularFile>,
        extension: ReleaseExtension
    ): TaskProvider<WriteVersionTask> =
        tasks.register("writeReleaseVersion", WriteVersionTask::class.java) {
            it.dependsOn(calculateReleaseVersionTask)
            it.versionType.set(VersionType.RELEASE)
            it.releaseVersionStore.set(releaseVersionStore)
            it.versionFile.set(extension.versionPropertyFile)
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

    private fun Project.configureGitTasks(
        extension: ReleaseExtension,
    ) {
        val commandHistoryService = project.registerGitHistoryService()

        tasks.withType(GitTask::class.java) {
            it.gitRootDirectory.set(extension.rootGitDirectory.asFile)
            it.gitCommandHistoryApi.set(commandHistoryService)
        }
    }

    private fun Project.registerExtension(): ReleaseExtension {
        val extension = extensions.create("release", ReleaseExtension::class.java)

        return extension
    }

    private fun Project.registerGitHistoryService(): Provider<GitCommandHistoryService> =
        gradle.sharedServices.registerIfAbsent(
            "commandHistory",
            GitCommandHistoryService::class.java
        )
}
