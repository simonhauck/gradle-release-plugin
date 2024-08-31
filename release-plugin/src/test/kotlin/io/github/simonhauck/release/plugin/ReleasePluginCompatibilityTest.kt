package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.io.TempDir

internal class ReleasePluginCompatibilityTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @TestFactory
    fun `plugin can be applied to different Gradle versions`(): List<DynamicTest> {
        val gradleVersions = listOf("8.0", "7.0", "6.1")

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
    fun `release is successful with gradle 6(dot)1`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withGradleVersion("6.1")
                    .withArguments("release", "-PreleaseType=major", "--stacktrace")
                    .build()

            assertThat(runner.task(":release")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }
}
