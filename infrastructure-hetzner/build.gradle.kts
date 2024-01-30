plugins {
    id("build.common.artifactory")
    id("build.common.kotlin-conventions")
    id("build.common.spring-conventions")
    application
}

dependencies {
    implementation(libs.springStarter)
    implementation(libs.cdktf)
}

application {
    mainClass.set(
        "com.github.cryptojuenger.template.infrastructure.hetzner.InfrastructureApplicationKt"
    )
}
