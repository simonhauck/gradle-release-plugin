package com.github.simonhauck.release.tasks

import com.github.simonhauck.release.impl.CommandLineParser
import com.github.simonhauck.release.impl.VersionHolderApi
import com.github.simonhauck.release.impl.VersionIncrementStrategy
import java.io.FileReader
import java.util.Properties
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault
abstract class CalculateReleaseVersionTask : DefaultTask() {

    init {
        group = Constants.groupName
        description = "Calculate the release version and the next development version"
    }

    @get:Internal abstract val versionHolder: Property<VersionHolderApi>
    @get:InputFile abstract val versionPropertyFile: RegularFileProperty
    @get:Input abstract val commandLineParameters: MapProperty<String, String>

    @TaskAction
    fun action() {
        val versionStrategy = getReleaseStrategyOrThrow()
        val versionFile = versionPropertyFile.get().asFile

        val currentVersion = readVersionProperty()

        val releaseVersion = versionStrategy.calculateReleaseVersion(currentVersion)
        val nextDevelopmentVersion = versionStrategy.calculateNextDevelopmentVersion(currentVersion)

        versionHolder
            .get()
            .setVersions(versionFile, currentVersion, releaseVersion, nextDevelopmentVersion)
    }

    private fun getReleaseStrategyOrThrow(): VersionIncrementStrategy {
        // TODO Simon.Hauck 2024-05-09 - improve error message
        return (CommandLineParser().parseVersionIncrementStrategy(commandLineParameters.get())
            ?: throw GradleException("No valid release strategy found."))
    }

    private fun readVersionProperty(): String {
        val properties = Properties()
        FileReader(versionPropertyFile.get().asFile).use { properties.load(it) }
        return properties.getProperty("version")
    }
}
