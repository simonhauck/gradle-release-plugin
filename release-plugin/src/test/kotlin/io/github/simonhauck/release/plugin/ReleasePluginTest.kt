package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

class ReleasePluginTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `the version file should contain the next development version at the end`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `no files should be changed, untracked or commited when the release plugin has finished successful`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(gitCommandApi.status().assertIsOk().allEmpty()).isTrue()
        }

    @Test
    fun `should successfully add additional configured values to the git push`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |release {
                |    releaseCommitAddFiles.set(listOf(file("version.properties"), file("otherFile.txt")))
                |}
            """
                    .trimMargin()
            )
            createValidGitRepository()
            tmpDir.resolve("otherFile.txt").writeText("Hello World")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            println(gitCommandApi.status())
            assertThat(gitCommandApi.status().assertIsOk().allEmpty()).isTrue()
        }

    @Test
    fun `should fail the task if an unknown file is added to git`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |release {
                |    releaseCommitAddFiles.set(listOf(file("version.properties"), file("unknownFile.txt")))
                |}
            """
                    .trimMargin()
            )

            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .buildAndFail()

            assertThat(runner.task(":commitReleaseVersion")?.outcome).isEqualTo(TaskOutcome.FAILED)
        }
    }

    @Test
    fun `should be able to add different files for release and post release commit that are created at runtime`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |release {
                |    releaseCommitAddFiles.set(listOf(file("version.properties"), file("release-file.txt")))
                |    postReleaseCommitAddFiles.set(listOf(file("version.properties"), file("post-release-file.txt")))
                |}
                |
                |val writeReleaseFileTask = tasks.register("writeReleaseFile") {
                |   dependsOn(tasks.writeReleaseVersion)
                |   inputs.property("fileContent", "value")
                |   val outputFile = layout.projectDirectory.file("release-file.txt")
                |   outputs.file(outputFile)
                |
                |   doLast { outputFile.asFile.writeText("value") }
                |}
                |
                |val writePostReleaseFileTask = tasks.register("writePostReleaseFile") {
                |   dependsOn(tasks.writePostReleaseVersion)
                |   inputs.property("fileContent", "value")
                |   val outputFile = layout.projectDirectory.file("post-release-file.txt")
                |   outputs.file(outputFile)
                |
                |   doLast { outputFile.asFile.writeText("value") }
                |}
                |
                |tasks.commitReleaseVersion { dependsOn(writeReleaseFileTask) }
                |tasks.commitPostReleaseVersion{ dependsOn(writePostReleaseFileTask) }
            """
                    .trimMargin()
            )

            createValidGitRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(gitCommandApi.status().assertIsOk().allEmpty()).isTrue()
            assertThat(tmpDir.resolve("release-file.txt")).exists()
            assertThat(tmpDir.resolve("post-release-file.txt")).exists()
        }
    }

    @Test
    fun `should use the version file location specified in the release extension`() =
        testDriver(tmpDir) {
            val fileName = "myOtherVersionFile.properties"

            val versionFile = File("$tmpDir/$fileName")
            versionFile.writeText("version=1.0.0")

            appendContentToBuildGradle(
                """
                    |release {
                    |    versionPropertyFile.set(layout.projectDirectory.file("$fileName"))
                    |}
                """
                    .trimMargin()
            )

            createValidGitRepository()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            assertThat(versionFile.readText()).isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `should revert all changes when the tag is already used`() =
        testDriver(tmpDir) {
            createValidGitRepository()

            gitCommandApi.tag("1.2.0", "some message")
            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            val initialVersion = tmpDir.resolve("version.properties").readText()
            assertThat(initialVersion).isEqualTo("version=1.2.1-SNAPSHOT")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.3.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":commitReleaseVersion")?.outcome
            val releaseResult = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(releaseResult).isEqualTo(null)
            assertThat(tmpDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }
}
