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
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.readVersionPropertiesFile())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `releasing with releaseType strategy should be successful`() =
        testDriver(tmpDir) {
            updateVersionProperties("1.0.1-SNAPSHOT")
            createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("release", "-PreleaseType=minor").build()

            val actual = runner.task(":release")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
            assertThat(client1WorkDir.readVersionPropertiesFile())
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
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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
                    .trimMargin())
            createValidRepositoryWithRemote()
            client1WorkDir.resolve("otherFile.txt").writeText("Hello World")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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
                    .trimMargin())

            createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .buildAndFail()

            assertThat(runner.task(":commitReleaseVersion")?.outcome).isEqualTo(TaskOutcome.FAILED)
        }
    }

    @Test
    fun `should add different files for release and post release commit that are created at runtime`() {
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
                    .trimMargin())

            createValidRepositoryWithRemote()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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
                    .trimMargin())

            createValidRepositoryWithRemote()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .buildAndFail()

            val actual = runner.task(":commitReleaseVersion")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(client1WorkDir.readVersionPropertiesFile()).isEqualTo("version=1.0.0")
        }

    @Test
    fun `the version file should contain the snapshot version after a successful release`() =
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            testKitRunner()
                .withArguments(
                    "release",
                    "-PreleaseVersion=1.2.0",
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                )
                .build()

            cloneForClient2()
            val version = client2WorkDir.readVersionPropertiesFile()
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
                    "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                )
                .build()

            cloneForClient2()
            client2Api.checkOutTag("v1.2.0").assertIsOk()
            val version = client2WorkDir.readVersionPropertiesFile()
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
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .buildAndFail()

            val actual = runner.task(":pushRelease")?.outcome
            val actualVersion = client1WorkDir.readVersionPropertiesFile()

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(actualVersion).isEqualTo("version=1.0.0")
            assertThat(client1Api.log().get()).hasSize(1)
            assertThat(client1Api.listTags().get()).isEmpty()
        }

    @Test
    fun `should not revert unrelated files if a push fails`() =
        testDriver(tmpDir) {
            val file = client1WorkDir.resolve("testFile.txt").apply { writeText("hello") }
            appendContentToBuildGradle(
                """
                |release {
                |    checkForUncommittedFiles.set(false)
                |}
                """
                    .trimMargin())

            createLocalRepository()

            file.writeText("unrelated change")

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
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

    @Test
    fun `should by default fail the release if an uncommitted file is in the repository and revert the local changes`() =
        testDriver(tmpDir) {
            updateVersionProperties("1.0.0")
            createLocalRepository()

            client1WorkDir.resolve("uncommittedFile.txt").createNewFile()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .buildAndFail()

            val actual = runner.task(":checkForUncommittedFiles")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .contains(
                    "> The repository contains uncommitted files:",
                    "   - untracked: uncommittedFile.txt",
                )
            assertThat(client1WorkDir.readVersionPropertiesFile()).isEqualTo("version=1.0.0")
        }

    @Test
    fun `should skip the check for uncommitted files when the check is disabled`() =
        testDriver(tmpDir) {
            updateVersionProperties("1.0.0")
            appendContentToBuildGradle(
                """
                |release {
                |   checkForUncommittedFiles.set(false)
                |}
                """
                    .trimMargin())
            createValidRepositoryWithRemote()

            client1WorkDir.resolve("uncommittedFile.txt").createNewFile()

            val runner =
                testKitRunner()
                    .withArguments(
                        "release",
                        "-PreleaseVersion=1.2.0",
                        "-PpostReleaseVersion=1.2.1-SNAPSHOT",
                    )
                    .build()

            val actual = runner.task(":checkForUncommittedFiles")?.outcome

            assertThat(actual).isEqualTo(TaskOutcome.SKIPPED)
            assertThat(client1WorkDir.readVersionPropertiesFile())
                .isEqualTo("version=1.2.1-SNAPSHOT")
        }

    @Test
    fun `should commit the files with the configured user`() =
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |release {
                |   gitName.set("Test User")
                |   gitEmail.set("test@mail.de")
                |}
                """
                    .trimMargin())

            createValidRepositoryWithRemote()

            testKitRunner().withArguments("release", "-PreleaseType=minor").build()

            val lastCommit = client1Api.log().assertIsOk().last()
            assertThat(lastCommit.message).isEqualTo("Post release commit: v1.1.1-SNAPSHOT")
            assertThat(lastCommit.commiterName).isEqualTo("Test User")
            assertThat(lastCommit.commiterEmail).isEqualTo("test@mail.de")
        }

    @Test
    fun `should use the default user if the git user is not fully configured`() {
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            testKitRunner().withArguments("release", "-PreleaseType=minor").build()

            val lastCommit = client1Api.log().assertIsOk().last()

            assertThat(lastCommit.message).isEqualTo("Post release commit: v1.1.1-SNAPSHOT")
            assertThat(lastCommit.commiterName).isEqualTo("user1")
            assertThat(lastCommit.commiterEmail).isEqualTo("user1@mail.com")
        }
    }

    @Test
    fun `should support property files with colon as separator and other unrelated properties`() {
        testDriver(tmpDir) {
            createValidRepositoryWithRemote()

            val versionFile =
                client1WorkDir.resolve("version.properties").apply {
                    writeText(
                        """
                    |# Some comment
                    |unrelatedProperty: unrelatedValue
                    |version: 1.0.0
                    |someProperty: value
                """
                            .trimMargin())
                }

            testKitRunner().withArguments("release", "-PreleaseType=major").build()

            assertThat(versionFile.readLines())
                .containsExactly(
                    "# Some comment",
                    "unrelatedProperty: unrelatedValue",
                    "version: 2.0.1-SNAPSHOT",
                    "someProperty: value",
                )
        }
    }

    @Test
    fun `release should fail it the project uses a snapshot dependency`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |val implementation by configurations.creating{}
                |
                |repositories { gradlePluginPortal() }
                |dependencies { implementation("io.github.simonhauck.release:release-plugin:1.0.0-RC1") }
            """
                    .trimMargin())
            createLocalRepository()

            val runner = testKitRunner().withArguments("release").buildAndFail()

            assertThat(runner.task(":checkForPreReleaseVersions")?.outcome)
                .isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .contains(
                    "> Found 1 dependencies with a pre-release version that are not allowed",
                    "   - io.github.simonhauck.release:release-plugin:1.0.0-RC1",
                    "  Change the versions or add them to the ignore list.",
                )
        }
    }

    @Test
    fun `release should succeed without any snapshot dependencies`() {
        testDriver(tmpDir) {
            appendContentToBuildGradle(
                """
                |val implementation by configurations.creating{}
                |
                |repositories { gradlePluginPortal() }
                |dependencies { implementation("io.github.simonhauck.release:release-plugin:1.0.0") }
            """
                    .trimMargin())
            createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("release", "-PreleaseType=major").build()

            assertThat(runner.task(":checkForPreReleaseVersions")?.outcome)
                .isEqualTo(TaskOutcome.SUCCESS)
            assertThat(runner.task(":release")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
        }
    }
}
