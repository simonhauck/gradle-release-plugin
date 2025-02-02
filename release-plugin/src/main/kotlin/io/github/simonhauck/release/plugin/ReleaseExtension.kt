package io.github.simonhauck.release.plugin

import java.io.File
import java.time.Duration
import org.gradle.api.file.ProjectLayout
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider

abstract class ReleaseExtension(
    private val objects: ObjectFactory,
    private val layout: ProjectLayout,
) {
    // Project properties
    val rootGitDirectory: RegularFileProperty = projectFileProperty("./")
    val versionPropertyFile: RegularFileProperty = projectFileProperty("version.properties")

    // Check for snapshot / pre-release versions
    val checkForPreReleaseVersions: Property<Boolean> = booleanProperty(true)
    val checkRecursiveForPreReleaseVersions: Property<Boolean> = booleanProperty(true)
    val ignorePreReleaseDependenciesFile: RegularFileProperty = fileProperty()
    val ignorePreReleaseDependencies: ListProperty<String> = stringListProperty()

    // Check for uncommited files
    val checkForUncommittedFiles: Property<Boolean> = booleanProperty(true)

    // Git config
    val gitName: Property<String> = stringProperty()
    val gitEmail: Property<String> = stringProperty()
    val sshKeyFile: RegularFileProperty = fileProperty()
    val commitMessagePrefix: Property<String> = stringProperty("")
    val disablePush: Property<Boolean> = booleanProperty(false)

    // Release commit
    val releaseCommitAddFiles: ListProperty<File> =
        fileListProperty(versionPropertyFile.map { listOf(it.asFile) })
    val tagName: Property<String> = stringProperty("v{version}")
    val releaseCommitMessage: Property<String> = stringProperty("Release commit: v{version}")

    // Post release commit
    val postReleaseCommitAddFiles: ListProperty<File> =
        fileListProperty(versionPropertyFile.map { listOf(it.asFile) })
    val postReleaseCommitMessage = stringProperty("Post release commit: v{version}")
    val delayBeforePush: Property<Duration> = durationProperty(Duration.ZERO)

    // Utility methods

    private fun stringProperty(default: String? = null): Property<String> =
        objects.property(String::class.java).convention(default)

    private fun stringListProperty(default: List<String> = emptyList()): ListProperty<String> =
        objects.listProperty(String::class.java).convention(default)

    private fun projectFileProperty(default: String?): RegularFileProperty =
        objects.fileProperty().convention(default?.let { layout.projectDirectory.file(it) })

    private fun fileProperty(): RegularFileProperty = objects.fileProperty()

    private fun booleanProperty(default: Boolean? = null): Property<Boolean> =
        objects.property(Boolean::class.java).convention(default)

    private fun fileListProperty(default: Provider<List<File>>): ListProperty<File> =
        objects.listProperty(File::class.java).convention(default)

    private fun durationProperty(default: Duration? = null): Property<Duration> =
        objects.property(Duration::class.java).convention(default)
}
