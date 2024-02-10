package com.github.simonhauck.gradlesemanticversioning

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradleSemanticVersioningPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.register("exampleTask", ExampleTask::class.java)
        println("Project configured")
    }
}
