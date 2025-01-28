package io.github.simonhauck.release.testdriver

import io.github.simonhauck.release.git.internal.process.ProcessWrapper
import java.io.File

sealed interface GitServer : AutoCloseable {

    val lastRepository: RepositoryUrl?

    fun setup()

    fun initBareRepository(repositoryName: String= "testRepo"): RepositoryUrl
}

class LocalGitServer(tmpDir: File) : GitServer {

    private val serverDir: File = tmpDir.resolve("server").apply { mkdirs() }
    private val processWrapper = ProcessWrapper()

    private var lastRepositoryUrl: RepositoryUrl? = null

    override val lastRepository: RepositoryUrl?
        get() = lastRepositoryUrl

    override fun setup() {
        // Not required
    }

    override fun initBareRepository(repositoryName: String): RepositoryUrl {
        val repositoryPath = serverDir.resolve(repositoryName).absolutePath
        val repositoryUrl = RepositoryUrl(repositoryPath)

        processWrapper.runCommand(listOf("git", "init", "--bare", repositoryPath))

        lastRepositoryUrl = repositoryUrl
        return repositoryUrl
    }

    override fun close() {
        serverDir.deleteRecursively()
    }
}

data class RepositoryUrl(val url: String) {}
