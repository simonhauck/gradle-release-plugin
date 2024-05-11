package io.github.simonhauck.release.version.api

import java.io.Serializable

sealed interface VersionIncrementStrategy {

    fun calculateReleaseVersion(currentVersion: String): String

    fun calculateNextDevelopmentVersion(currentVersion: String): String

    data class SpecifyExplicitly(
        val releaseVersion: String,
        val nextDevelopmentVersion: String,
    ) : VersionIncrementStrategy, Serializable {

        override fun calculateReleaseVersion(currentVersion: String): String {
            return releaseVersion
        }

        override fun calculateNextDevelopmentVersion(currentVersion: String): String {
            return nextDevelopmentVersion
        }
    }
}
