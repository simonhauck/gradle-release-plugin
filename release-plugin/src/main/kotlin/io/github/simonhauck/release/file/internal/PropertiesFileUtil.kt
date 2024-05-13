package io.github.simonhauck.release.file.internal

import java.io.File
import java.util.*

internal class PropertiesFileUtil {

    fun readProperties(file: File): Map<String, String> {
        val apply = Properties().apply { file.inputStream().use { load(it) } }
        return apply.map { it.key.toString() to it.value.toString() }.toMap()
    }

    fun writePropertiesFile(file: File, values: Map<String, String>) {
        val content =
            values
                .map { (key, value) -> "$key=$value" }
                .sorted()
                .joinToString { System.lineSeparator() }

        file.writeText(content)
    }
}
