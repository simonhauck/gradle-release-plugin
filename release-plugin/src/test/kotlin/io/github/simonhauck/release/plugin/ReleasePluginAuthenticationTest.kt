package io.github.simonhauck.release.plugin

import io.github.simonhauck.release.testdriver.GitTestCommandService
import io.github.simonhauck.release.testdriver.ReleasePluginTestDriver
import io.github.simonhauck.release.testdriver.assertIsOk
import io.github.simonhauck.release.testdriver.getTestResourceFile
import java.io.File
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.testcontainers.containers.BindMode
import org.testcontainers.containers.ExecConfig
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

internal class ReleasePluginAuthenticationTest {

    @TempDir private lateinit var tmpDir: File

    private val testDriver = ReleasePluginTestDriver()

    @Test
    fun `test Git server container`() {

        val publicKeyContent = getTestResourceFile("ssh-key/id_rsa.pub").readText()
        val privateKey = getTestResourceFile("ssh-key/id_rsa")

        val serverWorkDir = tmpDir.resolve("server").apply { mkdirs() }
        val authorizedKeyFile =
            serverWorkDir.resolve("authorized_keys").apply { writeText(publicKeyContent) }

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
            GitTestCommandService(
                tmpDir,
                privateKey.canonicalFile,
                disableStrictHostKeyChecking = true,
            )

        try {
            api.clone("ssh://git@${host}:${port}/srv/git/your-repo.git", "client2").assertIsOk()
        } finally {
            gitServer.stop()
        }
        // Add your test logic here

    }
}
