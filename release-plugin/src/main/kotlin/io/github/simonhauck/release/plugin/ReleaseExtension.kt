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

    val releaseCommitMessage: Property<String> =
        objects.property(String::class.java).convention("Release commit: v{version}")

    val postReleaseCommitMessage: Property<String> =
        objects.property(String::class.java).convention("Post release commit: v{version}")

    val commitMessagePrefix: Property<String> = objects.property(String::class.java).convention("")

    val tagName: Property<String> = objects.property(String::class.java).convention("v{version}")
}
