import java.util.*

plugins { id("build.common.kotlin-conventions") apply false }

allprojects { group = "com.github.github.simonhauck.gradle-semantic-versioning" }

private fun readVersionFromFile(file: File): String = readProperties(file).getProperty("version")

private fun readProperties(propertiesFile: File) =
    Properties().apply { propertiesFile.inputStream().use { fis -> load(fis) } }
