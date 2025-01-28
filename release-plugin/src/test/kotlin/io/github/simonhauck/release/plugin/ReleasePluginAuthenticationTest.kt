package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.*
import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

@RequiresDocker
internal class ReleasePluginAuthenticationTest {

    @TempDir private lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    private lateinit var publicKey: File
    private lateinit var privateKey: File

    @BeforeEach
    fun setUp() {
        publicKey = getRSAPublicKey()
        privateKey = getRSAKeyInTempDirectoryWithCorrectPermissions(tmpDir)
    }

    @Test
    fun `release does work with an authenticated user`() =
        testDriver(
            tmpDir,
            gitServer = DockerGitServer(publicKey, tmpDir),
            client1Config = ClientConfig(privateKey, false),
        ) {
            val sanitizedPath = privateKey.absolutePath.replace("\\", "\\\\")

            appendContentToBuildGradle(
                """
                |release {
                |   sshKeyFile = file("$sanitizedPath")
                |}
                |
                |tasks.withType<GitTask>{
                |   strictHostKeyChecking = false
                |}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

            val runner = testKitRunner().withArguments("release", "-PreleaseType=major").build()

            val actual = runner.task(":release")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.SUCCESS)
        }

    @Test
    fun `release fails if the client 1 uses an unauthorized private key`() =
        testDriver(
            tmpDir,
            gitServer = DockerGitServer(publicKey, tmpDir),
            client1Config = ClientConfig(privateKey, false),
        ) {
            val privateKey2 = getTestResourceFile("ssh-key/id_rsa2")
            val sanitizedPath = privateKey2.absolutePath.replace("\\", "\\\\")

            appendContentToBuildGradle(
                """
                |release {
                |   sshKeyFile = file("$sanitizedPath")
                |}
                |
                |tasks.withType<GitTask>{
                |   strictHostKeyChecking = false
                |}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

            val runner =
                testKitRunner().withArguments("release", "-PreleaseType=major").buildAndFail()

            val actual = runner.task(":pushRelease")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "  git@localhost: Permission denied (publickey).",
                    "  fatal: Could not read from remote repository.",
                    "  Please make sure you have the correct access rights",
                    "  and the repository exists.",
                )
        }

    @Test
    fun `release fails if the git server is not in the known hosts file`() =
        testDriver(
            tmpDir,
            gitServer = DockerGitServer(publicKey, tmpDir),
            client1Config = ClientConfig(privateKey, false),
        ) {
            val sanitizedPath = privateKey.absolutePath.replace("\\", "\\\\")

            appendContentToBuildGradle(
                """
                |release {
                |   sshKeyFile = file("$sanitizedPath")
                |}
                |
                |tasks.withType<GitTask>{
                |   strictHostKeyChecking = true
                |}
                """
                    .trimMargin()
            )

            createValidRepositoryWithRemote()

            val runner =
                testKitRunner().withArguments("release", "-PreleaseType=major").buildAndFail()

            val actual = runner.task(":pushRelease")?.outcome
            assertThat(actual).isEqualTo(TaskOutcome.FAILED)
            assertThat(runner.output.lines())
                .containsSequence(
                    "  Host key verification failed.",
                    "  fatal: Could not read from remote repository.",
                    "  Please make sure you have the correct access rights",
                    "  and the repository exists.",
                )
        }
}
