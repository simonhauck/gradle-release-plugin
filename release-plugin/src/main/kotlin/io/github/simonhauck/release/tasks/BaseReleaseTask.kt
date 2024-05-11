package io.github.simonhauck.release.tasks

import org.gradle.api.DefaultTask

abstract class BaseReleaseTask : DefaultTask() {
    init {
        group = "release"
    }
}
