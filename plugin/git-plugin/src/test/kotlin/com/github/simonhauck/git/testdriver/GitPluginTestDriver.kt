package com.github.simonhauck.git.testdriver

import com.github.simonhauck.git.process.ProcessConfig
import com.github.simonhauck.git.wrapper.GitCommandApi
import com.github.simonhauck.git.wrapper.GitCommandProcessWrapper
import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.gradle.testkit.runner.GradleRunner

private val log = KotlinLogging.logger {}

class GitPluginTestDriver {

    operator fun invoke(tmpDir: File, action: GitPluginProjectBuilder.() -> Unit) {
        log.info { "Current test directory is $tmpDir" }

        GitPluginProjectBuilder(tmpDir).apply {
            createProjectScaffold()
            action()
        }
    }
}

class GitPluginProjectBuilder(private val workDir: File) {

    val gitCommandApi: GitCommandApi =
        GitCommandProcessWrapper(config = ProcessConfig(workingDir = workDir))

    fun testKitRunner(): GradleRunner {
        return GradleRunner.create()
            .withProjectDir(workDir)
            .withPluginClasspath()
            .withDebug(true)
            .forwardOutput()
    }

    fun createValidGitRepository() {
        gitCommandApi.gitInit("main")

        File(workDir, "README.md").writeText("# Test Project")
        gitCommandApi.gitAdd(".")
        gitCommandApi.gitCommit("Initial commit")
    }

    fun createProjectScaffold() {
        val sourceDir = Paths.get("src/test/resources/scaffold-project")

        // Define the list of files to copy
        val filesToCopy = listOf("settings.gradle.kts", "build.gradle.kts", "gradle.properties")

        // Copy each file to the workDir
        filesToCopy.forEach { filePath ->
            val sourcePath = sourceDir.resolve(filePath)
            val targetPath = Paths.get(workDir.absolutePath, filePath)
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)
        }
    }

    fun appendContentToBuildGradle(content: String) {
        val buildGradlePath = Paths.get(workDir.absolutePath, "build.gradle.kts")
        val buildGradleFile = buildGradlePath.toFile()
        buildGradleFile.appendText(content)
    }
}
