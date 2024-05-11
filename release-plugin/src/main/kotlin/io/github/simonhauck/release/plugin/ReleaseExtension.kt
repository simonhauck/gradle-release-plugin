package io.github.simonhauck.release.plugin

import org.gradle.api.file.ProjectLayout
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

abstract class ReleaseExtension(
    objects: ObjectFactory,
    layout: ProjectLayout,
) {
    val rootGitDirectory: RegularFileProperty =
        objects.fileProperty().convention(layout.projectDirectory.file("./"))

    val versionPropertyFile: RegularFileProperty =
        objects.fileProperty().convention(layout.projectDirectory.file("version.properties"))

    val releaseBranchName: Property<String> =
        objects.property(String::class.java).convention("main")
}
