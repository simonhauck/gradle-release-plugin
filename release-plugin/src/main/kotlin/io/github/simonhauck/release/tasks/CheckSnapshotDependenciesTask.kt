package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitStatusResult
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

abstract class CheckForUncommitedFilesTask : BaseReleaseTask(), GitTask {

    @TaskAction
    fun action() {
        val uncommitedFiles = gitCommandApi().status().getOrThrowGradleException()

        if (uncommitedFiles.notEmpty()) {
            throw GradleException(buildErrorMessage(uncommitedFiles))
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
