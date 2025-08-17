package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.fail
import org.junit.jupiter.api.io.TempDir

internal class ReleasePluginCompatibilityTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @TestFactory
    fun `plugin can be applied to different Gradle versions`(): List<DynamicTest> {
        val gradleVersions = listOf("8.2", "8.7", "8.12")

        return gradleVersions.map { gradleVersion ->
            DynamicTest.dynamicTest("Gradle version $gradleVersion") {
                testDriver(tmpDir) {

                    // Run the 'help' task to check if the plugin was applied successfully
                    val runner =
                        testKitRunner()
                            .withGradleVersion(gradleVersion)
                            .withArguments("help")
                            .build()

                    assertThat(runner.task(":help")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
                }
            }
        }
    }

    @Test
    fun `plugin can not be applied to projects with gradle 8(dot)1`() =
        testDriver(tmpDir) {
            client1Api.createValidRepositoryWithRemote()

            runCatching {
                    testKitRunner()
                        .withGradleVersion("8.1")
                        .withArguments("release", "-PreleaseType=major", "--stacktrace")
                        .build()
                }
                .onSuccess {
                    fail("This is unexpected. The plugin can not be applied to gradle 8.1?")
                }
        }

    @Test
    fun `release is successful with gradle 8(dot)2`() =
        testDriver(tmpDir) {
            client1Api.createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withGradleVersion("8.2")
                    .withArguments("release", "-PreleaseType=major", "--stacktrace")
                    .build()

            assertThat(runner.task(":release")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }
}
