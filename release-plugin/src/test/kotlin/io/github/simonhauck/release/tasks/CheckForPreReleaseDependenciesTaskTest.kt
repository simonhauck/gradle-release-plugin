package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class CheckForPreReleaseDependenciesTaskTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    private val alphaVersionDependency = "\"some.group:lib:1.0.0-alpha\""
    private val snapshotVersionDependency = "\"other.xy:lib2:1.0.0-SNAPSHOT\""
    private val releaseVersionDependency = "\"released.dep:great:1.0.0\""

    @Test
    fun `should fail and list the dependencies that are a pre-release version`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       $alphaVersionDependency,
                |       $snapshotVersionDependency,
                |       $releaseVersionDependency,
                |    )
                |}
                """
                    .trimMargin())

            val runner =
                testKitRunner().withArguments("testCheckForPreReleaseDependencies").buildAndFail()

            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "> Found 2 dependencies with a pre-release version that are not allowed",
                    "   - other.xy:lib2:1.0.0-SNAPSHOT",
                    "   - some.group:lib:1.0.0-alpha",
                    "  Change the versions or add them to the ignore list.")
        }

    @Test
    fun `task should be successful if no pre-release version is used`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       $releaseVersionDependency,
                |    )
                |}
                """
                    .trimMargin())

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not list snapshot dependencies that are specified in the ignore list`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `should not list snapshot dependencies that are specified in the ignore file`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `should not fail if a version has an unexpected format`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `task should be up to date when invoked twice`() {
        TODO("Not yet implemented")
    }
}
