package com.github.simonhauck.release.version.internal

import com.github.simonhauck.release.version.api.VersionIncrementStrategy
import com.github.simonhauck.release.version.api.VersionIncrementStrategy.SpecifyExplicitly

internal class VersionIncrementStrategyParser {

    fun parse(parameters: Map<String, String>): VersionIncrementStrategy? {
        val releaseVersion = parameters["releaseVersion"]
        val nextDevelopmentVersion = parameters["nextDevVersion"]

        if (releaseVersion != null && nextDevelopmentVersion != null) {
            return SpecifyExplicitly(releaseVersion, nextDevelopmentVersion)
        }

        return null
    }
}
