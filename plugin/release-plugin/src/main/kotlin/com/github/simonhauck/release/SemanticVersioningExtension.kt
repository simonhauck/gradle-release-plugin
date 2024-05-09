package com.github.simonhauck.release

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property

abstract class SemanticVersioningExtension {
    abstract val rootGitDirectory: RegularFileProperty
    abstract val versionPropertyFile: RegularFileProperty

    abstract val releaseBranchName: Property<String>
}
