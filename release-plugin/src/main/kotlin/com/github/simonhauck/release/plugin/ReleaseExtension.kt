package com.github.simonhauck.release.plugin

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property

// TODO Simon.Hauck 2024-05-10 - #11 provide default values in release extension
abstract class ReleaseExtension {
    abstract val rootGitDirectory: RegularFileProperty
    abstract val versionPropertyFile: RegularFileProperty

    abstract val releaseBranchName: Property<String>
}
