package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.git.api.CommandHistoryApi
import io.github.simonhauck.release.git.api.RevertCommand
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

abstract class CreateBranchTask : BaseReleaseTask() {

    @get:Input abstract val branchName: Property<String>

    @get:Internal abstract val commandHistoryApi: Property<CommandHistoryApi>

    @TaskAction
    fun action() {
        val branch = branchName.get()
        gitCommandApi()
            .createBranch(branch)
            .map { commandHistoryApi.get().registerRevertCommand(buildRevertCommand()) }
            .onLeft { commandHistoryApi.get().revertAllCommands() }
            .getOrThrowGradleException()
    }

    private fun buildRevertCommand(): RevertCommand {
        val name = branchName.get()
        val message = "Deleting branch $name"
        return RevertCommand(message) { gitCommandApi().deleteBranch(name) }
    }
}
