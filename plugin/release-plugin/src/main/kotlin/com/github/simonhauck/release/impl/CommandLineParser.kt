package com.github.simonhauck.release.impl

internal class CommandLineParser {

    fun parseVersionIncrementStrategy(parameters: Map<String, String>): VersionIncrementStrategy? {
        val releaseVersion = parameters["releaseVersion"]
        val nextDevelopmentVersion = parameters["nextDevVersion"]

        if (releaseVersion != null && nextDevelopmentVersion != null) {
            return VersionIncrementStrategy.SpecifyVersionExplicitly(
                releaseVersion = releaseVersion,
                nextDevelopmentVersion = nextDevelopmentVersion
            )
        }

        return null
    }
}
