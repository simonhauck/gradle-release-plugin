import java.io.File
import java.io.FileInputStream
import java.util.*

plugins {
    id("build.common.kotlin-conventions") apply false
}

allprojects {
    group = "com.github.cryptojuenger.template"
    version = readVersionFromFile(file("${rootProject.projectDir.resolve("version.properties")}"))
}

fun readVersionFromFile(file: File): String {
    val fis = FileInputStream(file)
    val prop = Properties()
    prop.load(fis)

    return prop.getProperty("version")
}

