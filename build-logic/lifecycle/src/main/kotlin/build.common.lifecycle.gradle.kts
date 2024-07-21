plugins { `lifecycle-base` }

object LifeCycleUtility {

    fun TaskProvider<*>.dependsOnSameTaskInSubmodules(
        excludedModule: List<String> = emptyList(),
    ) {
        this { dependsOnSameTaskInSubmodules(excludedModule) }
    }

    fun Task.dependsOnSameTaskInSubmodules(
        excludedModule: List<String> = emptyList(),
    ) {
        project.subprojects
            .filterNot { it.name in excludedModule }
            .forEach { subproject -> dependsOn(":${subproject.name}:${this.name}") }
    }

    fun TaskProvider<*>.dependsOnSameTaskInIncludedBuilds(
        excludedModule: List<String> = emptyList(),
    ) {
        this { dependsOnSameTaskInIncludedBuilds(excludedModule) }
    }

    fun Task.dependsOnSameTaskInIncludedBuilds(
        excludedModule: List<String> = emptyList(),
    ) {
        project.gradle.includedBuilds
            .filterNot { it.name in excludedModule }
            .forEach { includedBuild -> dependsOn(includedBuild.task(":${this.name}")) }
    }
}

abstract class CheckJvmArgsCompatibilityTask : DefaultTask() {
    @get:InputFiles abstract val gradlePropertiesFiles: ListProperty<File>

    init {
        outputs.upToDateWhen { true }
    }

    @TaskAction
    fun checkCompatibility() {
        val jvmArgKey = "org.gradle.jvmargs"
        val distinctJvmArgs =
            gradlePropertiesFiles
                .get()
                .map { readProperties(it) }
                .map { it.getProperty(jvmArgKey) }
                .distinct()

        val allDistinct = distinctJvmArgs.size == 1
        if (!allDistinct) {
            val fileNames = gradlePropertiesFiles.get().joinToString(" and ") { it.path }
            throw GradleException(
                "$fileNames have different $jvmArgKey which may cause two daemons to be spawned on CI and in IDEA. " +
                    "Use the same org.gradle.jvmargs for both builds.")
        }
    }

    private fun readProperties(propertiesFile: File) =
        java.util.Properties().apply { propertiesFile.inputStream().use { fis -> load(fis) } }
}
