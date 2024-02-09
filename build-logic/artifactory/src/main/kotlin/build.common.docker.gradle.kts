import com.google.cloud.tools.jib.gradle.JibTask

plugins { id("com.google.cloud.tools.jib") }

jib {
    to {
        val version = version.toString()
        val channel = if (version.endsWith("SNAPSHOT")) "snapshot" else "stable"

        tags = setOf(version, channel)
        // Java21 Image not yet working https://github.com/GoogleContainerTools/jib/issues/4137
        from { image = "eclipse-temurin:21-jre" }
        auth {
            username = System.getenv("DOCKER_USER")
            password = System.getenv("DOCKER_PASSWORD")
        }
    }
}

tasks.withType<JibTask> {
    notCompatibleWithConfigurationCache(
        "Not yet supported: https://github.com/GoogleContainerTools/jib/issues/3132"
    )
}
