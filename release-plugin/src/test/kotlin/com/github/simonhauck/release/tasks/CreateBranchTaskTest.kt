package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.git.api.get
import com.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class CreateBranchTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

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

    @Test
    fun `should delete revert the git changes when the second createBranchTask fails`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            appendContentToBuildGradle(
                """
                |tasks.register<CreateBranchTask>("createBranch") {
                |    branchName.set("feature/branch")
                |}
                |
                |tasks.register<CreateBranchTask>("createBranch2") {
                |    dependsOn("createBranch")
                |    branchName.set("feature/branch")
                |}
            """
                    .trimMargin()
            )

            createValidGitRepository()

            val runner = testKitRunner().withArguments("createBranch2", "--info").buildAndFail()
            assertThat(runner.task(":createBranch")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(runner.task(":createBranch2")?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(gitCommandApi.getLocalBranchNames().get()).doesNotContain("feature/branch")
        }
}
