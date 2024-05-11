package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.GitCommandHistoryApi
import io.github.simonhauck.release.git.api.RevertCommand
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

abstract class CreateBranchTask : BaseReleaseTask() {

    @get:Input abstract val branchName: Property<String>

    @get:Internal abstract val gitCommandHistoryApi: Property<GitCommandHistoryApi>

    @TaskAction
    fun action() {
        val branch = branchName.get()
        gitCommandApi()
            .createBranch(branch)
            .map { gitCommandHistoryApi.get().registerRevertCommand(buildRevertCommand()) }
            .onLeft { gitCommandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()
    }

    private fun buildRevertCommand(): RevertCommand {
        val name = branchName.get()
        val message = "Deleting branch $name"
        return RevertCommand(message) { gitCommandApi().deleteBranch(name) }
    }
}
