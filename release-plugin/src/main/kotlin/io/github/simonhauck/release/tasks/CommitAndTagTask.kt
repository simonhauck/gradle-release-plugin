package io.github.simonhauck.release.tasks

import arrow.core.fold
import io.github.simonhauck.release.file.internal.PropertiesFileUtil
import io.github.simonhauck.release.git.api.RevertCommand
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

abstract class CommitAndTagTask : BaseReleaseTask(), GitTask {

    @get:Input abstract val commitMessage: Property<String>
    @get:Input @get:Optional abstract val gitAddFilePattern: Property<String>
    @get:Input @get:Optional abstract val commitMessagePrefix: Property<String>
    @get:Input @get:Optional abstract val tagName: Property<String>
    @get:Input @get:Optional abstract val tagPrefix: Property<String>
    @get:Input @get:Optional abstract val tagMessage: Property<String>
    @get:Input @get:Optional abstract val tagMessagePrefix: Property<String>
    @get:InputFile @get:Optional abstract val stringTemplateVariables: RegularFileProperty

    init {
        description = "Add the specified files to git, commit them and optionally tag the commit"
    }

    // TODO Simon.Hauck 2024-05-13 - test task with template variables

    @TaskAction
    fun action() {
        val templateVariables = readTemplateVariables()

        val commitMessage = commitMessage.get().replaceVariables(templateVariables)
        val commitPrefix = commitMessagePrefix.getOrElse("").replaceVariables(templateVariables)
        val gitAddPattern = gitAddFilePattern.getOrElse(".").replaceVariables(templateVariables)

        val tagName = tagName.getOrElse("").replaceVariables(templateVariables)
        val tagPrefix = tagPrefix.getOrElse("").replaceVariables(templateVariables)
        val tagMessage = tagMessage.getOrElse(commitMessage).replaceVariables(templateVariables)
        val tagMessagePrefix = tagMessagePrefix.getOrElse("").replaceVariables(templateVariables)

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

    private fun readTemplateVariables() =
        stringTemplateVariables.orNull?.asFile?.let { PropertiesFileUtil().readProperties(it) }
            ?: emptyMap()

    private fun String.replaceVariables(variables: Map<String, String>): String {
        return variables.fold(this) { acc, (key, value) -> acc.replace("{$key}", value) }
    }
}
