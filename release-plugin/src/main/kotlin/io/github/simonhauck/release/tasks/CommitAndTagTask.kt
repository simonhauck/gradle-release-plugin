package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.RevertCommand
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

abstract class CommitAndTagTask : BaseReleaseTask(), GitTask {

    @get:Input abstract val commitMessage: Property<String>
    @get:Input @get:Optional abstract val gitAddFilePattern: Property<String>
    @get:Input @get:Optional abstract val commitPrefix: Property<String>
    @get:Input @get:Optional abstract val tagName: Property<String>
    @get:Input @get:Optional abstract val tagPrefix: Property<String>
    @get:Input @get:Optional abstract val tagMessage: Property<String>
    @get:Input @get:Optional abstract val tagMessagePrefix: Property<String>

    init {
        description = "Add the specified files to git, commit them and optionally tag the commit"
    }

    @TaskAction
    fun action() {
        val commitMessage = commitMessage.get()
        val commitPrefix = commitPrefix.getOrElse("")
        val gitAddPattern = gitAddFilePattern.getOrElse(".")

        val tagName = tagName.getOrElse("")
        val tagPrefix = tagPrefix.getOrElse("")
        val tagMessage = tagMessage.getOrElse(commitMessage)
        val tagMessagePrefix = tagMessagePrefix.getOrElse("")

        gitCommandApi()
            .add(gitAddPattern)
            .onRight {
                gitCommandHistoryApi
                    .get()
                    .registerRevertCommand(buildGitAddRevertCommand(gitAddPattern))
            }
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()

        gitCommandApi()
            .commit("$commitPrefix$commitMessage")
            .map { gitCommandHistoryApi.get().registerRevertCommand(buildGitCommitRevertCommand()) }
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()

        if (tagName.isNotEmpty()) {
            val fullTagName = "$tagPrefix$tagName"
            gitCommandApi()
                .tag(fullTagName, "$tagMessagePrefix$tagMessage")
                .map {
                    gitCommandHistoryApi
                        .get()
                        .registerRevertCommand(buildGitTagRevertCommand(fullTagName))
                }
                .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
                .getOrThrowGradleException()
        }
    }

    private fun buildGitAddRevertCommand(filePattern: String): RevertCommand =
        RevertCommand("Reverting git add $filePattern") { gitCommandApi().reset(filePattern) }

    private fun buildGitCommitRevertCommand(): RevertCommand =
        RevertCommand("Deleting last commit") { gitCommandApi().deleteLastCommit() }

    private fun buildGitTagRevertCommand(fullTagName: String): RevertCommand =
        RevertCommand("Deleting tag $fullTagName") { gitCommandApi().deleteLocalTag(fullTagName) }
}
