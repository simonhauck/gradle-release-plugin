package io.github.simonhauck.release.util

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency

internal class ProjectVersionCollector {

    fun getProjectDependencies(project: Project): List<String> {
        return project.configurations.flatMap { it.dependencies }.asStringList()
    }

    fun getProjectDependenciesRecursive(project: Project): List<String> {
        val projectDependencies = getProjectDependencies(project)
        val subProjectDependencies =
            project.subprojects.flatMap { getProjectDependenciesRecursive(it) }

        return projectDependencies + subProjectDependencies
    }

    private fun List<Dependency>.asStringList(): List<String> {
        return filter { it.group != null && it.version != null }
            .map { "${it.group}:${it.name}:${it.version}" }
    }
}
