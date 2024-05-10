package com.github.simonhauck.release.version

import com.github.simonhauck.release.version.VersionIncrementStrategy.SpecifyExplicitly

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
