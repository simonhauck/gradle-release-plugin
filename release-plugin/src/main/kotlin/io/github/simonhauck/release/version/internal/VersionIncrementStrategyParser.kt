package io.github.simonhauck.release.version.internal

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionIncrementStrategyParserApi
import org.gradle.api.GradleException

private val log = KotlinLogging.logger {}

internal class VersionIncrementStrategyParser : VersionIncrementStrategyParserApi {

    private val parsers =
        listOf(
            ManualVersionSelectionStrategy(),
            ReleaseTypeSelectionStrategy(),
        )

    override fun parseOrThrow(
        currentVersion: Version,
        parameters: Map<String, String>
    ): ReleaseVersions {
        val parsedVersion = parsers.firstNotNullOfOrNull { it.tryParse(currentVersion, parameters) }

        if (parsedVersion == null) {
            log.error { "No version increment strategy found" }
            parsers.forEach {
                log.error { "Available strategy: ${it.strategyName}" }
                it.requiredPropertyDescription.forEach { log.error { "\t $it" } }
            }

            throw GradleException("No valid version increment strategy found.")
        }

        return parsedVersion
    }
}
