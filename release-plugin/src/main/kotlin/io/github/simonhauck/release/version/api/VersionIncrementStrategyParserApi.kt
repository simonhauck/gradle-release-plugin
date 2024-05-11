package io.github.simonhauck.release.version.api

import io.github.simonhauck.release.version.internal.VersionIncrementStrategyParser

interface VersionIncrementStrategyParserApi {

    fun parseOrThrow(currentVersion: Version, parameters: Map<String, String>): ReleaseVersions

    companion object {
        fun create(): VersionIncrementStrategyParserApi = VersionIncrementStrategyParser()
    }
}
