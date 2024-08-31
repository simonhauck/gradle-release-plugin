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
                    .trimMargin()
            )

            val runner =
                testKitRunner().withArguments("testCheckForPreReleaseDependencies").buildAndFail()

            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "> Found 2 dependencies with a pre-release version that are not allowed",
                    "   - other.xy:lib2:1.0.0-SNAPSHOT",
                    "   - some.group:lib:1.0.0-alpha",
                    "  Change the versions or add them to the ignore list.",
                )
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
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not list snapshot dependencies that are specified in the ignore list`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       $snapshotVersionDependency,
                |    )
                |    ignorePreReleaseDependencies = listOf($snapshotVersionDependency)
                |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `task should not fail because of snapshot dependencies that are only listed with group and name in the ignore list`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       $snapshotVersionDependency,
                |    )
                |    ignorePreReleaseDependencies = listOf("other.xy:lib2")
                |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()

            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not list snapshot dependencies that are specified in the ignore file`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
            |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
            |    usedDependencies = setOf(
            |       $snapshotVersionDependency,
            |    )
            |    ignorePreReleaseDependenciesFile = file("ignore.txt")
            |}
            """
                    .trimMargin()
            )
            client1WorkDir
                .resolve("ignore.txt")
                .writeText(snapshotVersionDependency.replace("\"", ""))

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `should not fail if a version has an unexpected format`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       "some.group:lib:1.0.0.a1",
                |       "other.xy:lib2:1.0",
                |       "released.dep:great:1.0.0-1.2.6",
                |    )
                |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }
    }

    @Test
    fun `should fail and list dependencies that are not following the semver standard but still indicate pre-release versions`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       "some.group:lib:1.0.0.v1-SNAPSHOT",
                |       "some.group:lib:1.0.0.v1-RC",
                |       "some.group:lib:1.0.0.v1-RC1",
                |       "some.group:lib:1.0.0.v1-alpha",
                |       "some.group:lib:1.0.0.v1-ALPHA",
                |       "some.group:lib:1.0.0.v1-BETA",
                |       "some.group:lib:1.0.0.v1-pre",
                |       "some.group:lib:1.0.0.v1-m3",
                |       "some.group:lib:1.0.0.v1-M2",
                |    )
                |}
                """
                    .trimMargin()
            )

            val runner =
                testKitRunner().withArguments("testCheckForPreReleaseDependencies").buildAndFail()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "> Found 9 dependencies with a pre-release version that are not allowed",
                    "   - some.group:lib:1.0.0.v1-ALPHA",
                    "   - some.group:lib:1.0.0.v1-BETA",
                    "   - some.group:lib:1.0.0.v1-M2",
                    "   - some.group:lib:1.0.0.v1-RC",
                    "   - some.group:lib:1.0.0.v1-RC1",
                    "   - some.group:lib:1.0.0.v1-SNAPSHOT",
                    "   - some.group:lib:1.0.0.v1-alpha",
                    "   - some.group:lib:1.0.0.v1-m3",
                    "   - some.group:lib:1.0.0.v1-pre",
                    "  Change the versions or add them to the ignore list.",
                )
        }
    }

    @Test
    fun `task should be up to date when invoked twice`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |tasks.register<CheckForPreReleaseDependenciesTask>("testCheckForPreReleaseDependencies") {
                |    usedDependencies = setOf(
                |       $releaseVersionDependency,
                |    )
                |}
                """
                    .trimMargin()
            )

            val runner = testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val actual = runner.task(":testCheckForPreReleaseDependencies")

            assertThat(actual?.outcome).isEqualTo(TaskOutcome.SUCCESS)

            val secondRunner =
                testKitRunner().withArguments("testCheckForPreReleaseDependencies").build()
            val secondActual = secondRunner.task(":testCheckForPreReleaseDependencies")

            assertThat(secondActual?.outcome).isEqualTo(TaskOutcome.UP_TO_DATE)
        }
    }
}
