package com.github.simonhauck.git.tasks

import com.github.simonhauck.git.testdriver.GitPluginTestDriver
import com.github.simonhauck.git.wrapper.get
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class CreateBranchTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = GitPluginTestDriver()

    @Test
    fun `tasks should fail if no git repository is available`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                    |tasks.register<CreateBranchTask>("createBranch") {
                    |    branchName.set("feature/branch")
                    |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("createBranch").buildAndFail()

            assertThat(runner.task(":createBranch")?.outcome).isEqualTo(TaskOutcome.FAILED)
        }

    @Test
    fun `task should be successful if a valid git repository is available`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                    |tasks.register<CreateBranchTask>("createBranch") {
                    |    branchName.set("feature/branch")
                    |}
                """
                    .trimMargin()
            )

            createValidGitRepository()

            val runner = testKitRunner().withArguments("createBranch").build()

            assertThat(runner.task(":createBranch")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(gitCommandApi.getLocalBranchNames().get()).contains("feature/branch")
        }
}
