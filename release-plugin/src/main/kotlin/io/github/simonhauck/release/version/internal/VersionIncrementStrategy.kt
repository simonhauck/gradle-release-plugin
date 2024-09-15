package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.version.api.ReleaseVersions
import io.github.simonhauck.release.version.api.Version

internal sealed interface VersionIncrementStrategy {

    val strategyName: String

    val requiredPropertyDescription: List<String>

    fun tryParse(currentVersion: Version, parameters: Map<String, String>): ReleaseVersions?
}
