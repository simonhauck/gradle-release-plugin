package io.github.simonhauck.release.plugin

import java.io.File
import java.time.Duration
import org.gradle.api.file.ProjectLayout
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property

abstract class ReleaseExtension(
    objects: ObjectFactory,
    layout: ProjectLayout,
) {
    val rootGitDirectory: RegularFileProperty =
        objects.fileProperty().convention(layout.projectDirectory.file("./"))

    val versionPropertyFile: RegularFileProperty =
        objects.fileProperty().convention(layout.projectDirectory.file("version.properties"))

    val releaseCommitAddFiles: ListProperty<File> =
        objects
            .listProperty(File::class.java)
            .convention(versionPropertyFile.map { listOf(it.asFile) })

    val releaseCommitMessage: Property<String> =
        objects.property(String::class.java).convention("Release commit: v{version}")

    val postReleaseCommitAddFiles: ListProperty<File> =
        objects
            .listProperty(File::class.java)
            .convention(versionPropertyFile.map { listOf(it.asFile) })

    val postReleaseCommitMessage: Property<String> =
        objects.property(String::class.java).convention("Post release commit: v{version}")

    val commitMessagePrefix: Property<String> = objects.property(String::class.java).convention("")

    val tagName: Property<String> = objects.property(String::class.java).convention("v{version}")

    val gitName: Property<String> = objects.property(String::class.java)

    val gitEmail: Property<String> = objects.property(String::class.java)

    val sshKeyFile: RegularFileProperty = objects.fileProperty()

    val disablePush: Property<Boolean> = objects.property(Boolean::class.java).convention(false)

    val delayBeforePush: Property<Duration> =
        objects.property(Duration::class.java).convention(Duration.ZERO)

    val checkForUncommittedFiles: Property<Boolean> =
        objects.property(Boolean::class.java).convention(true)
}
