package com.github.simonhauck.git

import org.gradle.api.file.RegularFileProperty

abstract class GitPluginExtension {
    abstract val gitRootDirectory: RegularFileProperty
}
