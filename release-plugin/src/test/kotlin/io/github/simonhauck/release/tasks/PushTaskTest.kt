package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import io.github.simonhauck.release.testdriver.getTestResourceFile
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class PushTaskTest {

    @TempDir lateinit var tmpDir: File
    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `should push the commit to the remote repository`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){}
                """
                    .trimMargin()
            )
            client1Api.add("build.gradle.kts")
            client1Api.commit("pushTaskMessage")

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)

            cloneForClient2()
            val latestCommit = client2Api.log().assertIsOk().last()
            assertThat(latestCommit.message).isEqualTo("pushTaskMessage")
        }

    @Test
    fun `should fail if there is no remote origin available`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){}
                """
                    .trimMargin()
            )

            createLocalRepository()

            val runner = testKitRunner().withArguments("testPush").buildAndFail()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
        }

    @Test
    fun `should not fail if no valid repository is available but disable push is true`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
            |tasks.register<PushTask>("testPush"){
            |   disablePush = true
            |}
            """
                    .trimMargin()
            )

            createLocalRepository()

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not fail to pull the remote changes when unstaged files are available`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

            updateVersionProperties("untracked-file.txt")

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not fail to pull the remote changes when staged files are available`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

            updateVersionProperties("untracked-file.txt")
            client1Api.add("version.properties")

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should be successful when specifying an ssh key`() =
        testDriver(tmpDir) {
            val sshKeyFile = getTestResourceFile("ssh-key/id_rsa")

            createValidRepositoryWithRemote()

            val absolutePath = sshKeyFile.canonicalFile.absolutePath.replace("\\", "\\\\")
            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){
                |   sshKeyFile = file("$absolutePath")
                |}
                """
                    .trimMargin()
            )
            client1Api.add("build.gradle.kts")
            client1Api.commit("pushTaskMessage")

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should be successful when specifying an ssh key with a whitespace in the folder name`() =
        testDriver(tmpDir) {
            val sshKeyFolder = tmpDir.resolve("folder with whitespaces/id_rsa")
            val sshKeyFile = getTestResourceFile("ssh-key/id_rsa").copyTo(sshKeyFolder)

            createValidRepositoryWithRemote()

            val absolutePath = sshKeyFile.canonicalFile.absolutePath.replace("\\", "\\\\")

            println(absolutePath)

            appendContentToBuildGradle(
                """
                |tasks.register<PushTask>("testPush"){
                |   sshKeyFile = file("$absolutePath")
                |}
                """
                    .trimMargin()
            )
            client1Api.add("build.gradle.kts")
            client1Api.commit("pushTaskMessage")

            val runner = testKitRunner().withArguments("testPush").build()

            val actual = runner.task(":testPush")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }
}
