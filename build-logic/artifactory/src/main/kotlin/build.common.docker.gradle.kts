plugins { id("com.google.cloud.tools.jib") }

jib {
    to {
        val registry = ""
        val version = "${project.version}"

        val channel = if (version.endsWith("SNAPSHOT")) "snapshot" else "stable"

        image = "$registry/${project.rootProject.name}"
        tags = setOf(version, channel)
        auth {
            username = System.getenv("DOCKER_USR")
            password = System.getenv("DOCKER_PSW")
        }
    }
}
