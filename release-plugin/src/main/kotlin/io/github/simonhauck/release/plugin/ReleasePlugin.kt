package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.git.internal.commands.GitCommandHistoryService
import io.github.simonhauck.release.tasks.*
import java.time.Duration
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Property
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

        val checkForUncommittedFilesTask =
            project.checkForUncommittedFiles(extension, commitReleaseVersion)

        val pushReleaseTask =
            project.registerPushTask(
                "pushRelease",
                extension,
                listOf(commitReleaseVersion, checkForUncommittedFilesTask)
            )

        val writePostReleaseVersionTask =
            project.tasks.register("writePostReleaseVersion", WriteVersionTask::class.java) {
                it.dependsOn(pushReleaseTask)
                it.versionType.set(VersionType.NEXT_DEV)
                it.releaseVersionStore.set(releaseVersionStore)
                it.versionFile.set(extension.versionPropertyFile)
            }

        val commitPostReleaseVersionTask =
            project.registerPostReleaseCommitTask(writePostReleaseVersionTask, extension)

        val pushPostRelease =
            project.registerPushTask(
                "pushPostRelease",
                extension,
                listOf(commitPostReleaseVersionTask),
                extension.delayBeforePush
            )

        project.tasks.register("release", BaseReleaseTask::class.java) {
            it.description = "Release the current version"
            it.dependsOn(pushPostRelease)
        }
    }

    private fun Project.checkForUncommittedFiles(
        extension: ReleaseExtension,
        taskDependencies: TaskProvider<*>
    ): TaskProvider<CheckForUncommittedFilesTask> {
        return tasks.register(
            "checkForUncommittedFiles",
            CheckForUncommittedFilesTask::class.java
        ) {
            it.onlyIf { extension.checkForUncommittedFiles.get() }
            it.dependsOn(taskDependencies)
        }
    }

    private fun Project.registerPushTask(
        name: String,
        extension: ReleaseExtension,
        dependsOn: List<TaskProvider<*>>,
        delay: Property<Duration> = objects.property(Duration::class.java).value(Duration.ZERO)
    ): TaskProvider<PushTask> =
        tasks.register(name, PushTask::class.java) {
            it.dependsOn(dependsOn)
            it.disablePush.set(extension.disablePush)
            it.delayBeforePushInMs.set(delay)
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
            it.templateVariables.set(extension.versionPropertyFile)
            it.gitAddFilePattern.set(extension.releaseCommitAddFiles)
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
            it.templateVariables.set(extension.versionPropertyFile)
            it.gitAddFilePattern.set(extension.postReleaseCommitAddFiles)
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
            it.sshKeyFile.set(extension.sshKeyFile)
            it.gitName.set(extension.gitName)
            it.gitEmail.set(extension.gitEmail)
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
        ) {
            // Intentionally left empty for compatibility with older gradle versions
        }
}
