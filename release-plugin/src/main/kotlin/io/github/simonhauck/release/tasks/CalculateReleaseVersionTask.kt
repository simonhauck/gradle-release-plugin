package io.github.simonhauck.release.tasks

import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionHolderApi
import io.github.simonhauck.release.version.api.VersionIncrementStrategyParserApi
import java.io.File
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.logging.Logging
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*

abstract class CalculateReleaseVersionTask : BaseReleaseTask(), GitTask {

    private val log = Logging.getLogger(CalculateReleaseVersionTask::class.java)

    init {
        description = "Calculate the release version and the next development version"
        // Run this task always, because the git repository could have changed, (e.g. the tags)
        outputs.upToDateWhen { false }
    }

    @get:InputFile abstract val versionPropertyFile: RegularFileProperty
    @get:Deprecated("Use releaseVersionStore instead")
    @get:Input
    @get:Optional
    abstract val releaseVersionStorePath: Property<File>
    @get:Input abstract val commandLineParameters: MapProperty<String, String>
    @get:Input abstract val releaseTagName: Property<String>

    @get:OutputFile abstract val releaseVersionStore: RegularFileProperty

    @TaskAction
    fun action() {
        val versionHolder = VersionHolderApi.create(releaseVersionStore.get().asFile)
        val currentVersion =
            versionHolder.loadVersionFromFileOrThrow(versionPropertyFile.get().asFile)
        val releaseVersions = getReleaseVersions(currentVersion)

        log.lifecycle("Determined versions $releaseVersions")

        versionHolder.saveVersions(releaseVersions)
    }

    private fun getReleaseVersions(currentVersion: Version): ReleaseVersions =
        VersionIncrementStrategyParserApi.create(gitCommandApi(), releaseTagName.get())
            .parseOrThrow(currentVersion, commandLineParameters.get())
}
