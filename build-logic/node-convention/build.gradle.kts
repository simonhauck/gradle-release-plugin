plugins { `kotlin-dsl` }

description =
    "Configures common tasks for node related projects, e.g. node setup, dependency installation, formatting, ..."

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.nodeGradlePlugin)
}
