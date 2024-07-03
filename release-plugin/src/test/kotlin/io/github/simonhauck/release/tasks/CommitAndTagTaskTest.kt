package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class CommitAndTagTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should add, commit and tag the selected file`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            File(client1WorkDir, "newFile.txt").writeText("Hello World")
            File(client1WorkDir, "otherFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                    |tasks.register<CommitAndTagTask>("commitAndTag") {
                    |    commitMessage.set("new commit")
                    |    gitAddFilePattern.set(listOf(file("newFile.txt")))
                    |    commitMessagePrefix.set("feat: ")
                    |    tagName.set("1.0.0")
                    |    tagPrefix.set("v")
                    |    tagMessage.set("Initial tag")
                    |    tagMessagePrefix.set("tag: ")
                    |}
                """
                    .trimMargin())

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1Api.listTags().assertIsOk()).contains("v1.0.0")
            assertThat(client1Api.status().assertIsOk().untracked).contains("otherFile.txt")
            assertThat(client1Api.log().assertIsOk().map { it.message })
                .contains("feat: new commit")
        }

    @Test
    fun `should add and commit multiple files`() {
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            File(client1WorkDir, "newFile.txt").writeText("Hello World")
            File(client1WorkDir, "otherFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                    |tasks.register<CommitAndTagTask>("commitAndTag") {
                    |    commitMessage.set("new commit")
                    |    gitAddFilePattern.set(listOf(file("newFile.txt"), file("otherFile.txt")))
                    |}
                """
                    .trimMargin())

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1Api.status().assertIsOk().untracked).isEmpty()
        }
    }

    @Test
    fun `should not tag the commit if tagName is not set`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            File(client1WorkDir, "newFile.txt").writeText("Hello World")

            appendContentToBuildGradle(
                """
                    |tasks.register<CommitAndTagTask>("commitAndTag") {
                    |    commitMessage.set("new commit")
                    |    gitAddFilePattern.set(listOf(file("newFile.txt")))
                    |}
                """
                    .trimMargin())

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1Api.listTags().assertIsOk()).isEmpty()
        }

    @Test
    fun `git tag should fail and revert the previous commands when the tag is already set`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CommitAndTagTask>("commitAndTag") {
                |    commitMessage.set("new commit")
                |    gitAddFilePattern.set(listOf(file("newFile.txt")))
                |    tagName.set("v1.0.0")
                |}
            """
                    .trimMargin())
            createValidRepositoryWithRemote()
            client1Api.tag("v1.0.0", "Initial tag").assertIsOk()
            File(client1WorkDir, "newFile.txt").writeText("Hello World")

            val runner = testKitRunner().withArguments("commitAndTag", "--info").buildAndFail()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(client1Api.listTags().assertIsOk()).contains("v1.0.0")
            assertThat(client1Api.log().assertIsOk().map { it.message })
                .doesNotContain("new commit")
            assertThat(client1Api.status().assertIsOk().allEmpty()).isTrue()
        }

    @Test
    fun `should replace the template variables with the values from the properties file`() {
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            appendContentToBuildGradle(
                """
                |tasks.register<CommitAndTagTask>("commitAndTag") {
                |    commitMessage.set("{var1} message")
                |    gitAddFilePattern.set(listOf(file(".")))
                |    commitMessagePrefix.set("Prefix {var2}: ")
                |    tagName.set("v-{var3}")
                |    tagPrefix.set("{var4}-")
                |    tagMessage.set("{var5} ")
                |    tagMessagePrefix.set("{var6}: ")
                |    templateVariables.set(file("variables.properties"))
                |}
            """
                    .trimMargin())

            client1WorkDir
                .resolve("variables.properties")
                .writeText(
                    """
                |var1=template commit
                |var2=feat
                |var3=some-template-version
                |var4=tag-prefix
                |var5=some-tag
                |var6=some-tag-prefix
                """
                        .trimMargin())

            val runner = testKitRunner().withArguments("commitAndTag").build()

            val actual = runner.task(":commitAndTag")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1Api.listTags().assertIsOk())
                .contains("tag-prefix-v-some-template-version")
            assertThat(client1Api.log().assertIsOk().last().message)
                .isEqualTo("Prefix feat: template commit message")
        }
    }
}
