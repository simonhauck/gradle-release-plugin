package com.github.simonhauck.git.tasks

import com.github.simonhauck.git.BaseGitTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class CreateBranchTask : BaseGitTask() {

    @get:Input abstract val branchName: Property<String>

    @TaskAction
    fun action() {
        gitCommandApi().createBranch(branchName.get()).getOrThrowGradleException()
    }
}
