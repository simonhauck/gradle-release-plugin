package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitStatusResult
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

abstract class CheckForUncommittedFilesTask : BaseReleaseTask(), GitTask {

    @TaskAction
    fun action() {
        val historyApi = gitCommandHistoryApi.get()

        val uncommitedFiles =
            gitCommandApi()
                .status()
                .onLeft { historyApi.revertAllCommands() }
                .getOrThrowGradleException()

        if (uncommitedFiles.notEmpty()) {
            val errorMessage = buildErrorMessage(uncommitedFiles)
            historyApi.revertAllCommands()
            throw GradleException(errorMessage)
        }
    }

    private fun buildErrorMessage(uncommitedFiles: GitStatusResult): String {
        val stagedFilesList = uncommitedFiles.staged.map { " - staged: $it" }
        val unstagedFilesList = uncommitedFiles.unstaged.map { " - unstaged: $it" }
        val untrackedFilesList = uncommitedFiles.untracked.map { " - untracked: $it" }
        val plus =
            listOf("The repository contains uncommited files:")
                .plus(stagedFilesList)
                .plus(unstagedFilesList)
                .plus(untrackedFilesList)

        return plus.joinToString("\n")
    }
}
