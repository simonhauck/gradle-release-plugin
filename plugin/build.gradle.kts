plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    `java-gradle-plugin`
}

@Suppress("UnstableApiUsage")
testing {
    suites {
        val test by
            getting(JvmTestSuite::class) {
                useJUnitJupiter()
                dependencies {
                    // Alternatively check this out:
                    // https://stackoverflow.com/questions/70448998/gradle-integration-test-suite-depending-on-testimplementation-dependencies
                    implementation.bundle(libs.bundles.springTestCore)
                }
            }

        val integrationTest by
            register<JvmTestSuite>("integrationTest") {
                dependencies {
                    implementation.bundle(libs.bundles.springTestCore)
                    implementation(project())
                }
            }
    }
}

@Suppress("UnstableApiUsage") tasks.check { dependsOn(testing.suites.named("integrationTest")) }

gradlePlugin {
    plugins {
        create("semantic-versioning-plugin") {
            id = "com.github.simonhauck.semantic-versioning"
            implementationClass =
                "com.github.simonhauck.gradlesemanticversioning.GradleSemanticVersioningPlugin"
        }
    }
}
