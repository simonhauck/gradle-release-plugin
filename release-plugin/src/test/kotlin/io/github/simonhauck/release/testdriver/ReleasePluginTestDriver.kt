package io.github.simonhauck.release.testdriver

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.gradle.api.logging.Logging
import org.gradle.testkit.runner.GradleRunner

internal class ReleasePluginTestDriver {
    private val log = Logging.getLogger(ReleasePluginTestDriver::class.java)

    operator fun invoke(
        tmpDir: File,
        gitServer: GitServer = LocalGitServer(tmpDir),
        client1Config: ClientConfig = ClientConfig(null),
        client2Config: ClientConfig = ClientConfig(null),
        action: SemanticVersioningProjectBuilder.() -> Unit,
    ) {
        log.lifecycle("Current test directory is $tmpDir")

        gitServer.use {
            gitServer.setup()
            val client1Api =
                GitTestCommandService(
                    tmpDir.resolve("client1"),
                    client1Config.privateKey,
                    client1Config.strictHostKeyChecking,
                )
            val client2Api =
                GitTestCommandService(
                    tmpDir.resolve("client2"),
                    client2Config.privateKey,
                    client2Config.strictHostKeyChecking,
                )

            SemanticVersioningProjectBuilder(client1Api, client2Api, it).apply {
                client1WorkDir.createProjectScaffold()
                action()
            }
        }
    }
}

internal class SemanticVersioningProjectBuilder(
    val client1Api: GitTestCommandService,
    val client2Api: GitTestCommandService,
    val gitServer: GitServer,
) {

    val client1WorkDir = client1Api.workDir
    val client2WorkDir = client2Api.workDir

    fun testKitRunner(): GradleRunner {
        return GradleRunner.create()
            .withProjectDir(client1Api.workDir)
            .withPluginClasspath()
            .withDebug(false)
            .forwardOutput()
    }

    fun GitTestCommandService.createValidRepositoryWithRemote() {
        val cloneUrl = gitServer.initBareRepository("testRepo")

        this.createLocalRepository()

        addRemoteAndSetUpstream("origin", cloneUrl.url, "main").assertIsOk()
        push().assertIsOk()
    }

    fun GitTestCommandService.createLocalRepository() {
        init("main").assertIsOk()
        configureNameAndEmailLocally("user1", "user1@mail.com").assertIsOk()
        add(".").assertIsOk()
        commit("Initial commit").assertIsOk()
    }

    fun cloneForClient2() {
        client2Api.clone(gitServer.lastRepository!!.url, ".", "main").assertIsOk()
        client2Api.configureNameAndEmailLocally("user2", "user2@mail.com").assertIsOk()
    }

    fun File.createProjectScaffold() {
        val sourceDir = Paths.get("src/test/resources/scaffold-project")

        Files.list(sourceDir).forEach { file ->
            val targetPath = Paths.get(this.absolutePath, file.fileName.toString())
            Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING)
        }
    }

    fun File.appendContentToBuildGradle(content: String) {
        val buildGradlePath = Paths.get(this.absolutePath, "build.gradle.kts")
        val buildGradleFile = buildGradlePath.toFile()
        buildGradleFile.appendText(content)
    }

    fun File.appendContentToSettingsGradle(content: String) {
        val settingsGradlePath = Paths.get(this.absolutePath, "settings.gradle.kts")
        val settingsGradleFile = settingsGradlePath.toFile()
        settingsGradleFile.appendText(content)
    }

    fun File.readGradleProperties(): List<String> {
        return Paths.get(this.absolutePath, "gradle.properties").toFile().readLines()
    }

    fun File.appendContentToGradleProperties(content: String) {
        val gradlePropertiesPath = Paths.get(this.absolutePath, "gradle.properties")
        val gradlePropertiesFile = gradlePropertiesPath.toFile()
        gradlePropertiesFile.appendText(content)
    }

    fun File.updateVersionProperties(version: String) {
        val versionPropertiesPath = Paths.get(this.absolutePath, "version.properties")
        val versionPropertiesFile = versionPropertiesPath.toFile()
        versionPropertiesFile.writeText("version=$version")
    }

    fun File.readVersionPropertiesFile(): String {
        return resolve("version.properties").readText()
    }
}

data class ClientConfig(val privateKey: File? = null, val strictHostKeyChecking: Boolean = false)
