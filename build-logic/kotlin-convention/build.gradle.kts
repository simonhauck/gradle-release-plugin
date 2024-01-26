plugins { `kotlin-dsl` }

description =
    "Configures common kotlin behavior, e.g. formatting, compile target, integration test tasks, ..."

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.testLoggerPlugin)
    implementation(libs.kotlinPlugin)
    implementation(libs.bundles.springBootPlugins)

    // Kotlin formatting
    implementation(libs.ktfmtPlugin)

}
