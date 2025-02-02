package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.git.api.GitCommandApi
import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version
import io.github.simonhauck.release.version.api.VersionIncrementStrategyParserApi
import org.gradle.api.GradleException
import org.gradle.api.logging.Logging

internal class VersionIncrementStrategyParser(
    gitCommandApi: GitCommandApi,
    releaseTagName: String,
) : VersionIncrementStrategyParserApi {
    private val log = Logging.getLogger(VersionIncrementStrategyParser::class.java)

    private val parsers =
        listOf(
            ManualVersionSelectionStrategy(),
            ReleaseTypeSelectionStrategy(gitCommandApi, releaseTagName),
        )

    override fun parseOrThrow(
        currentVersion: Version,
        parameters: Map<String, String>,
    ): ReleaseVersions {
        val parsedVersion = parsers.firstNotNullOfOrNull { it.tryParse(currentVersion, parameters) }

        if (parsedVersion == null) {
            log.error("No version increment strategy found")
            parsers.forEach { parser ->
                log.error("Available strategy: ${parser.strategyName}")
                parser.requiredPropertyDescription.forEach { log.error("\t $it") }
            }

            throw GradleException(
                "No valid version increment strategy found. Check the log or the documentation for the available parameters"
            )
        }

        return parsedVersion
    }
}
