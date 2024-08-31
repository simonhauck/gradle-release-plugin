package io.github.simonhauck.release.tasks

import org.gradle.api.GradleException
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.logging.Logging
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.SetProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

abstract class CheckForPreReleaseDependenciesTask : BaseReleaseTask() {

    private val log = Logging.getLogger(CheckForPreReleaseDependenciesTask::class.java)

    @get:InputFile @get:Optional abstract val ignorePreReleaseDependenciesFile: RegularFileProperty
    @get:Input @get:Optional abstract val ignorePreReleaseDependencies: ListProperty<String>

    @get:Input abstract val usedDependencies: SetProperty<String>

    init {
        outputs.upToDateWhen { true }
    }

    @TaskAction
    fun action() {
        val ignoredDependencies = combineIgnoredDependencies().toSet()

        val preReleaseDependencies =
            usedDependencies.get().filter { isPreReleaseVersion(it) }.sorted()

        val notAllowedDependencies =
            preReleaseDependencies.filterNot { it.startsWithAnyOf(ignoredDependencies) }

        if (notAllowedDependencies.isEmpty()) return

        val errorMessage = buildErrorMessage(notAllowedDependencies)
        throw GradleException(errorMessage)
    }

    private fun isPreReleaseVersion(it: String): Boolean {
        val split = it.split(":")
        if (split.size > 3)
            throw GradleException(
                "Something went wrong. Expected a dependency in form of group:name:version but got $it")

        if (split.size < 3) return false
        val version = split[2]

        val allChecks =
            listOf(
                version.contains("alpha", ignoreCase = true),
                version.contains("beta", ignoreCase = true),
                version.contains("beta", ignoreCase = true),
                version.contains("rc", ignoreCase = true),
                version.contains("pre", ignoreCase = true),
                version.contains("snapshot", ignoreCase = true),
                version.contains(".*[.-]M[0-9]+.*".toRegex(RegexOption.IGNORE_CASE)),
            )

        return allChecks.any { it }
    }

    private fun buildErrorMessage(notAllowedDependencies: List<String>): String {
        val header =
            "Found ${notAllowedDependencies.size} dependencies with a pre-release version that are not allowed\n"

        val list = notAllowedDependencies.joinToString("\n") { " - $it" }

        val hint = "\nChange the versions or add them to the ignore list."
        return header + list + hint
    }

    private fun String.startsWithAnyOf(list: Set<String>): Boolean {
        return list.any { this.startsWith(it) }
    }

    private fun combineIgnoredDependencies(): List<String> {
        val ignoreFromFile =
            ignorePreReleaseDependenciesFile.map { it.asFile.readLines() }.getOrElse(emptyList())

        val ignoredFromList = ignorePreReleaseDependencies.getOrElse(emptyList())

        return ignoreFromFile + ignoredFromList
    }
}
