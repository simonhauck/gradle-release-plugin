package io.github.simonhauck.release.testdriver

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.gradle.api.logging.Logging
import org.gradle.testkit.runner.GradleRunner

internal class ReleasePluginTestDriver {
    private val log = Logging.getLogger(ReleasePluginTestDriver::class.java)

    operator fun invoke(tmpDir: File, action: SemanticVersioningProjectBuilder.() -> Unit) {
        log.lifecycle("Current test directory is $tmpDir")

        SemanticVersioningProjectBuilder(
                tmpDir.resolve("client1"),
                tmpDir.resolve("client2"),
                tmpDir.resolve("server")
            )
            .apply {
                createProjectScaffold()
                action()
            }
    }
}

internal class SemanticVersioningProjectBuilder(
    val client1WorkDir: File,
    val client2WorkDir: File,
    val serverWorkDir: File
) {

    init {
        client1WorkDir.mkdirs()
        client2WorkDir.mkdirs()
        serverWorkDir.mkdirs()
    }

    val client1Api = GitTestCommandService(client1WorkDir)
    val client2Api = GitTestCommandService(client2WorkDir)
    val serverApi = GitTestCommandService(serverWorkDir)

    fun testKitRunner(): GradleRunner {
        return GradleRunner.create()
            .withProjectDir(client1WorkDir)
            .withPluginClasspath()
            .withDebug(false)
            .forwardOutput()
    }

    fun createValidRepositoryWithRemote() {
        serverApi.initBareRepository().assertIsOk()
        client1Api.init("main").assertIsOk()
        client1Api.add(".").assertIsOk()
        client1Api.commit("Initial commit").assertIsOk()
        client1Api
            .addRemoteAndSetUpstream("origin", serverWorkDir.absolutePath, "main")
            .assertIsOk()
        client1Api.push().assertIsOk()
    }

    fun createLocalRepository() {
        client1Api.init("main").assertIsOk()
        client1Api.add(".").assertIsOk()
        client1Api.commit("Initial commit").assertIsOk()
    }

    fun cloneForClient2() {
        client2Api.clone(serverWorkDir.absolutePath, ".", "main").assertIsOk()
    }

    fun createProjectScaffold() {
        val sourceDir = Paths.get("src/test/resources/scaffold-project")

        Files.list(sourceDir).forEach { file ->
            val targetPath = Paths.get(client1WorkDir.absolutePath, file.fileName.toString())
            Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING)
        }
    }

    fun appendContentToBuildGradle(content: String) {
        val buildGradlePath = Paths.get(client1WorkDir.absolutePath, "build.gradle.kts")
        val buildGradleFile = buildGradlePath.toFile()
        buildGradleFile.appendText(content)
    }

    fun updateVersionProperties(version: String) {
        val versionPropertiesPath = Paths.get(client1WorkDir.absolutePath, "version.properties")
        val versionPropertiesFile = versionPropertiesPath.toFile()
        versionPropertiesFile.writeText("version=$version")
    }

    fun File.readVersionPropertiesFile(): String {
        return resolve("version.properties").readText()
    }
}
