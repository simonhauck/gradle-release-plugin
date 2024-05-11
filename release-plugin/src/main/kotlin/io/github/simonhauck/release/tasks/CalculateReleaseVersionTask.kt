package io.github.simonhauck.release.tasks

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionHolderApi
import io.github.simonhauck.release.version.api.VersionIncrementStrategyParserApi
import java.io.File
import java.io.FileReader
import java.util.*
import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

private val log = KotlinLogging.logger {}

abstract class CalculateReleaseVersionTask : BaseReleaseTask() {

    init {
        description = "Calculate the release version and the next development version"
    }

    @get:InputFile abstract val versionPropertyFile: RegularFileProperty
    @get:Input abstract val releaseVersionStorePath: Property<File>
    @get:Input abstract val commandLineParameters: MapProperty<String, String>

    @get:OutputFile abstract val releaseVersionStore: RegularFileProperty

    @TaskAction
    fun action() {
        val currentVersion = readVersionProperty()
        val releaseVersions = getReleaseVersions(currentVersion)

        val versionHolder = VersionHolderApi.create(releaseVersionStore.get().asFile)

        log.info { "Determined versions $releaseVersions" }

        versionHolder.saveVersions(releaseVersions)
    }

    private fun getReleaseVersions(currentVersion: Version): ReleaseVersions =
        VersionIncrementStrategyParserApi.create()
            .parseOrThrow(currentVersion, commandLineParameters.get())

    private fun readVersionProperty(): Version {
        val properties = Properties()
        val versionFile = versionPropertyFile.get().asFile
        val filePath = versionFile.absolutePath

        FileReader(versionFile).use { properties.load(it) }

        return properties.getProperty("version")?.let { Version(it) }
            ?: throw GradleException("File $filePath does not contain a key 'version'")
    }
}
