description = "Provides plugins that are used by Gradle subprojects"

plugins { `lifecycle-base` }

tasks.check {
    dependsOn(subprojects.map { "${it.name}:check" })
    dependsOn(checkJvmArgsCompatibilityTask)
}

val checkJvmArgsCompatibilityTask =
    tasks.register<CheckJvmArgsCompatibilityTask>("checkJvmArgs") {
        gradlePropertiesFiles =
            listOf(
                layout.projectDirectory.file("gradle.properties").asFile,
                layout.projectDirectory.file("../gradle.properties").asFile,
                layout.projectDirectory.file("../release-plugin/gradle.properties").asFile,
            )
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
