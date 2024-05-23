package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
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
}
