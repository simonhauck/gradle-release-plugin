package com.github.simonhauck.release.testdriver

import com.github.simonhauck.git.wrapper.GitCommandApi
import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.gradle.testkit.runner.GradleRunner

private val log = KotlinLogging.logger {}

class SemanticVersioningPluginTestDriver {

    operator fun invoke(tmpDir: File, action: SemanticVersioningProjectBuilder.() -> Unit) {
        log.info { "Current test directory is $tmpDir" }

        SemanticVersioningProjectBuilder(tmpDir).apply {
            createProjectScaffold()
            createValidGitRepository()
            action()
        }
    }
}

class SemanticVersioningProjectBuilder(private val workDir: File) {

    val gitCommandApi: GitCommandApi = GitCommandApi.create(workDir)

    fun testKitRunner(): GradleRunner {
        return GradleRunner.create()
            .withProjectDir(workDir)
            .withPluginClasspath()
            .withDebug(true)
            .forwardOutput()
    }

    fun createValidGitRepository() {
        gitCommandApi.init("main")

        File(workDir, "README.md").writeText("# Test Project")
        gitCommandApi.add(".")
        gitCommandApi.commit("Initial commit")
    }

    fun createProjectScaffold() {
        val sourceDir = Paths.get("src/test/resources/scaffold-project")

        Files.list(sourceDir).forEach { file ->
            val targetPath = Paths.get(workDir.absolutePath, file.fileName.toString())
            Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING)
        }
    }

    fun appendContentToBuildGradle(content: String) {
        val buildGradlePath = Paths.get(workDir.absolutePath, "build.gradle.kts")
        val buildGradleFile = buildGradlePath.toFile()
        buildGradleFile.appendText(content)
    }

    fun updateVersionProperties(version: String) {
        val versionPropertiesPath = Paths.get(workDir.absolutePath, "version.properties")
        val versionPropertiesFile = versionPropertiesPath.toFile()
        versionPropertiesFile.writeText("version=$version")
    }
}
