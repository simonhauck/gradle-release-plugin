package io.github.simonhauck.release.tasks

import org.gradle.api.DefaultTask
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "Release tasks have side effects and should not be cached")
abstract class BaseReleaseTask : DefaultTask() {
    init {
        group = "release"
    }
}
