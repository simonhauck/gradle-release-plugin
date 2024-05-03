// ---------------------------------------------------------------------------------------------------------------------
// Register delegate tasks
// ---------------------------------------------------------------------------------------------------------------------

listOf(
        "build",
        "clean",
        "assemble",
        "check",
        "format",
        "checkFormat",
        "test",
    )
    .forEach { taskName ->
        tasks.register(taskName) {
            group = tasks.first().group
            dependsOn(tasksWithNameInSubmodules(taskName))
        }
    }

fun tasksWithNameInSubmodules(taskName: String): List<Task> {
    return subprojects.mapNotNull { it.tasks.findByName(taskName) }
}
