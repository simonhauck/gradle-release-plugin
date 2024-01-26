plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    id("build.common.spring-conventions")
    id("build.common.docker")

    // Generate open api doc
    alias(libs.plugins.openApiDoc)
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(libs.bundles.springStarterWeb)
    implementation(libs.springActuator)
    implementation(libs.springDataJdbc)

    implementation(libs.liquibase)
    runtimeOnly(libs.postgresDriver)

    developmentOnly(libs.springDevTools)
    developmentOnly(libs.springDockerCompose)
    annotationProcessor(libs.springAnnotationProcessor)
    annotationProcessor(libs.springAnnotationProcessor)

    testImplementation(libs.bundles.springTestCore)
}


