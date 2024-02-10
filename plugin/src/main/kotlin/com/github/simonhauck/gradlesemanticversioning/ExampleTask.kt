package com.github.simonhauck.gradlesemanticversioning

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class ExampleTask() : DefaultTask() {

    @TaskAction
    fun exampleTask() {
        println("This is an example task")
    }
}
