package com.github.simonhauck.git.tasks

import com.github.simonhauck.git.testdriver.GitPluginTestDriver
import com.github.simonhauck.git.wrapper.assertIsOk
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class CommitAndTagTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = GitPluginTestDriver()

    @Test
    fun `should add, commit and tag the selected files`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            File(tmpDir, "newFile.txt").writeText("Hello World")
            File(tmpDir, "otherFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                    |tasks.register<CommitAndTagTask>("commitAndTag") {
                    |    commitMessage.set("new commit")
                    |    gitAddFilePattern.set("newFile.txt")
                    |    commitPrefix.set("feat: ")
                    |    tagName.set("1.0.0")
                    |    tagPrefix.set("v")
                    |    tagMessage.set("Initial tag")
                    |    tagMessagePrefix.set("tag: ")
                    |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(gitCommandApi.listTags().assertIsOk()).contains("v1.0.0")
            assertThat(gitCommandApi.status().assertIsOk().untracked).contains("otherFile.txt")
            assertThat(gitCommandApi.log().assertIsOk().map { it.message })
                .contains("feat: new commit")
        }

    @Test
    fun `should not tag the commit if tagName is not set`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            File(tmpDir, "newFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                    |tasks.register<CommitAndTagTask>("commitAndTag") {
                    |    commitMessage.set("new commit")
                    |    gitAddFilePattern.set("newFile.txt")
                    |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(gitCommandApi.listTags().assertIsOk()).isEmpty()
        }

    @Test
    fun `git tag should fail and revert the previous commands when the tag is already set`() =
        testDriver(tmpDir) {
            createValidGitRepository()
            gitCommandApi.tag("v1.0.0", "Initial tag").assertIsOk()

            File(tmpDir, "newFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                |tasks.register<CommitAndTagTask>("commitAndTag") {
                |    commitMessage.set("new commit")
                |    gitAddFilePattern.set("newFile.txt")
                |    tagName.set("v1.0.0")
                |}
            """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("commitAndTag").buildAndFail()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(gitCommandApi.listTags().assertIsOk()).contains("v1.0.0")
            assertThat(gitCommandApi.log().assertIsOk().map { it.message })
                .doesNotContain("new commit")
            assertThat(gitCommandApi.status().assertIsOk().allEmpty()).isTrue()
        }
}
