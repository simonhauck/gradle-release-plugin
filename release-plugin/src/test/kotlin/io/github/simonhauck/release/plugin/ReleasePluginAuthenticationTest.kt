package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.*
import io.github.simonhauck.release.testdriver.GitTestCommandService
import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.testcontainers.containers.BindMode
import org.testcontainers.containers.ExecConfig
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

internal class ReleasePluginAuthenticationTest {

    @TempDir private lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    private val publicKey = getTestResourceFile("ssh-key/id_rsa.pub")
    private val privateKey = getTestResourceFile("ssh-key/id_rsa")

    @Test
    fun `test Git server container`() {

        val serverWorkDir = tmpDir.resolve("server").apply { mkdirs() }
        val authorizedKeyFile =
            serverWorkDir.resolve("authorized_keys").apply { writeText(publicKey.readText()) }

        val gitRepoMount = serverWorkDir.resolve("mount").apply { mkdirs() }

        val gitServer =
            GenericContainer(DockerImageName.parse("rockstorm/git-server"))
                .withExposedPorts(22)
                .withFileSystemBind(
                    authorizedKeyFile.canonicalPath,
                    "/home/git/.ssh/authorized_keys",
                    BindMode.READ_WRITE,
                )
                .withFileSystemBind(gitRepoMount.canonicalPath, "/srv/git", BindMode.READ_WRITE)
                .withEnv(mapOf("SSH_AUTH_METHODS" to "publickey"))
                .withCommand("/usr/sbin/sshd", "-D", "-e")

        gitServer.start()

        gitServer
            .execInContainer(
                ExecConfig.builder()
                    .command(arrayOf("chmod", "600", "/home/git/.ssh/authorized_keys"))
                    .build()
            )
            .apply {
                println(stdout)
                println(stderr)
            }

        gitServer
            .execInContainer(
                ExecConfig.builder()
                    .command(arrayOf("git", "init", "--bare", "/srv/git/your-repo.git"))
                    .user("git")
                    .workDir("/home/git")
                    .build()
            )
            .apply {
                println(stdout)
                println(stderr)
            }

        val port = gitServer.firstMappedPort
        val host = gitServer.host

        println("Port: $port")
        println("Host: $host")

        println(privateKey.canonicalFile)
        val api =
            GitTestCommandService(tmpDir, privateKey.canonicalFile, strictHostKeyChecking = false)

        try {
            api.clone("ssh://git@${host}:${port}/srv/git/your-repo.git", "client2").assertIsOk()
        } finally {
            gitServer.stop()
        }
        // Add your test logic here

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

            val runner = testKitRunner().withArguments("release", "-PreleaseType=major").buildAndFail()

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

            val runner = testKitRunner().withArguments("release", "-PreleaseType=major").buildAndFail()

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
