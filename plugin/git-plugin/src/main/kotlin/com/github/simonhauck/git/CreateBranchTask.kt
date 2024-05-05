package com.github.simonhauck.git

import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class CreateBranchTask : BaseGitTask() {

    @get:Input abstract val branchName: Property<String>

    @TaskAction
    fun action() {
        getGitCommandApi().createBranch(branchName.get())
    }
}
