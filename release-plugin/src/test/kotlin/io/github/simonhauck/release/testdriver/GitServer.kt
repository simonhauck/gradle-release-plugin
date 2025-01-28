package io.github.simonhauck.release.testdriver

import io.github.simonhauck.release.git.internal.process.ProcessWrapper
import java.io.File
import org.testcontainers.containers.BindMode
import org.testcontainers.containers.Container.ExecResult
import org.testcontainers.containers.ExecConfig
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

sealed interface GitServer : AutoCloseable {

    val lastRepository: RepositoryUrl?

    fun setup()

    fun initBareRepository(repositoryName: String = "testRepo"): RepositoryUrl
}

class LocalGitServer(tmpDir: File) : GitServer {

    private val serverDir: File = tmpDir.resolve("server").apply { mkdirs() }
    private val processWrapper = ProcessWrapper()

    private var _lastRepository: RepositoryUrl? = null

    override val lastRepository: RepositoryUrl?
        get() = _lastRepository

    override fun setup() {
        // Not required
    }

    override fun initBareRepository(repositoryName: String): RepositoryUrl {
        val repositoryPath = serverDir.resolve(repositoryName).absolutePath
        val repositoryUrl = RepositoryUrl(repositoryPath)

        processWrapper.runCommand(listOf("git", "init", "-b", "main", "--bare", repositoryPath))

        _lastRepository = repositoryUrl
        return repositoryUrl
    }

    override fun close() {
        serverDir.deleteRecursively()
    }
}

class DockerGitServer(private val authorizedPublicFile: File?, tmpDir: File) : GitServer {

    private val serverDir: File = tmpDir.resolve("server").apply { mkdirs() }

    private var container: GenericContainer<*> = configureContainer()

    private var _lastRepository: RepositoryUrl? = null

    override val lastRepository: RepositoryUrl?
        get() = _lastRepository

    private fun configureContainer(): GenericContainer<*> {
        val publicKeyContent = authorizedPublicFile?.readText() ?: ""

        val authorizedKeyFile =
            serverDir.resolve("authorized_keys").apply { writeText(publicKeyContent) }

        val gitRepoMount = serverDir.resolve("mount").apply { mkdirs() }

        return GenericContainer(DockerImageName.parse("rockstorm/git-server"))
            .withExposedPorts(22)
            .withFileSystemBind(
                authorizedKeyFile.canonicalPath,
                "/home/git/.ssh/authorized_keys",
                BindMode.READ_WRITE,
            )
            .withFileSystemBind(gitRepoMount.canonicalPath, "/srv/git", BindMode.READ_WRITE)
            .withEnv(mapOf("SSH_AUTH_METHODS" to "publickey"))
            .withCommand("/usr/sbin/sshd", "-D", "-e")
    }

    override fun setup() {
        container.start()

        container
            .execInContainer(
                ExecConfig.builder()
                    .command(arrayOf("chmod", "600", "/home/git/.ssh/authorized_keys"))
                    .build()
            )
            .printOutput()

    }

    override fun initBareRepository(repositoryName: String): RepositoryUrl {
        val directory = "/srv/git/$repositoryName.git"

        container
            .execInContainer(
                ExecConfig.builder()
                    .command(arrayOf("git", "init", "-b", "main",  "--bare", directory))
                    .user("git")
                    .workDir("/home/git")
                    .build()
            )
            .printOutput()

        val repositoryUrl =
            RepositoryUrl("ssh://git@${container.host}:${container.firstMappedPort}$directory")

        _lastRepository = repositoryUrl
        return repositoryUrl
    }

    override fun close() {
        container.stop()
    }

    private fun ExecResult.printOutput() {
        apply {
            println(stdout)
            println(stderr)
        }
    }
}

data class RepositoryUrl(val url: String)
