package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import io.github.simonhauck.release.testdriver.get
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

internal class ReleasePluginTest {

    @TempDir lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `the version file should contain the next development version at the end when the versions are set directly`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

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
            assertThat(client1WorkDir.resolve("version.properties").readText())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `releasing with releaseType strategy should be successful`() =
        testDriver(tmpDir) {
            updateVersionProperties("1.0.1-SNAPSHOT")
            createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseType=minor",
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.resolve("version.properties").readText())
                .isEqualTo("version=1.1.1-SNAPSHOT")
        }

    @Test
    fun `no files should be changed, untracked or commited when the release plugin has finished successful`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

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
            assertThat(client1Api.status().assertIsOk().allEmpty()).isTrue()
        }

    @Test
    fun `should successfully add additional configured files to the git commit`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |release {
                |    releaseCommitAddFiles.set(listOf(file("version.properties"), file("otherFile.txt")))
                |}
            """
                    .trimMargin()
            )
            createValidRepositoryWithRemote()
            client1WorkDir.resolve("otherFile.txt").writeText("Hello World")

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
            assertThat(client1Api.status().assertIsOk().allEmpty()).isTrue()
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

            createValidRepositoryWithRemote()

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

            createValidRepositoryWithRemote()

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
            assertThat(client1Api.status().assertIsOk().allEmpty()).isTrue()
            assertThat(client1WorkDir.resolve("release-file.txt")).exists()
            assertThat(client1WorkDir.resolve("post-release-file.txt")).exists()
        }
    }

    @Test
    fun `should use the version file location specified in the release extension`() =
        testDriver(tmpDir) {
            val fileName = "myOtherVersionFile.properties"

            val versionFile = client1WorkDir.resolve(fileName)
            versionFile.writeText("version=1.0.0")

            appendContentToBuildGradle(
                """
                    |release {
                    |    versionPropertyFile.set(layout.projectDirectory.file("$fileName"))
                    |}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

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
            updateVersionProperties("1.0.0")
            createValidRepositoryWithRemote()
            client1Api.tag("v1.2.0", "this tag is already existing")
            client1Api.push().assertIsOk()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":commitReleaseVersion")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(client1WorkDir.resolve("version.properties").readText())
                .isEqualTo("version=1.0.0")
        }

    @Test
    fun `the version file should contain the snapshot version after a successful release`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            cloneForClient2()
            val version = client2WorkDir.resolve("version.properties").readText()
            assertThat(version).isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `the version with the release tag should contain the release version in the version file`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                )
                .build()

            cloneForClient2()
            client2Api.checkOutTag("v1.2.0").assertIsOk()
            val version = client2WorkDir.resolve("version.properties").readText()
            assertThat(version).isEqualTo("version=1.2.0")
        }

    @Test
    fun `should revert the version file if no valid remote is available`() =
        testDriver(tmpDir) {
            updateVersionProperties("1.0.0")

            createLocalRepository()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":pushRelease")?.outcome
            val actualVersion = client1WorkDir.resolve("version.properties").readText()

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(actualVersion).isEqualTo("version=1.0.0")
            assertThat(client1Api.log().get()).hasSize(1)
            assertThat(client1Api.listTags().get()).isEmpty()
        }

    @Test
    fun `should not revert unrelated files if a push fails`() =
        testDriver(tmpDir) {
            val file = client1WorkDir.resolve("testFile.txt").apply { writeText("hello") }

            createLocalRepository()

            file.writeText("unrelated change")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.task(":pushRelease")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(file.readText()).contains("unrelated change")
        }

    @Test
    fun `should return a descriptive error message if the tag is already used`() {
        testDriver(tmpDir) {
            updateVersionProperties("1.0.0")
            createValidRepositoryWithRemote()
            client1Api.tag("v1.2.0", "this tag is already existing")
            client1Api.push().assertIsOk()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT"
                    )
                    .buildAndFail()

            val actual = runner.output.lines()

            assertThat(actual)
                .containsSequence(
                    "Execution failed for task ':commitReleaseVersion'.",
                    "> Failed to execute command: 'tag -a v1.2.0 -m Release commit: v1.2.0'",
                    "  Command finished with non zero exit code (code=128)",
                    "  --- Git output ---",
                    "  fatal: tag 'v1.2.0' already exists",
                    "  --- End of output ---",
                )
        }
    }
}
