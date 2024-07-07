package io.github.simonhauck.release.file.internal

import java.io.File
import java.util.*
import java.util.regex.Pattern
import org.gradle.api.logging.Logging

internal class PropertiesFileUtil {
    private val log = Logging.getLogger(PropertiesFileUtil::class.java)

    fun readProperties(file: File): Map<String, String> {
        val lines = file.readLinesIfExists()

        return lines.fold(emptyMap()) { acc, line ->
            val propertyFromLine = line.parseProperty().toMap()
            acc + propertyFromLine
        }
    }

    fun updatePropertiesFile(file: File, propertiesToUpdateOrAdd: Map<String, String>) {
        val existingProperties = readProperties(file)

        val propertiesToAdd = propertiesToUpdateOrAdd.minus(existingProperties.keys)

        file.appendProperties(propertiesToAdd)

        file.updateProperties(propertiesToUpdateOrAdd)
    }

    private fun File.updateProperties(propertiesToUpdateOrAdd: Map<String, String>) {
        val lines =
            readLinesIfExists().joinToString(System.lineSeparator()) {
                updatePropertyLine(it, propertiesToUpdateOrAdd)
            }
        writeText(lines)
    }

    private fun updatePropertyLine(
        line: String,
        propertiesToUpdateOrAdd: Map<String, String>
    ): String {
        val property = line.parseProperty() ?: return line
        val newValue = propertiesToUpdateOrAdd[property.first] ?: return line
        val separator = detectSeparatorForProperties(line) ?: return line

        return "${property.first}$separator$newValue"
    }

    private fun File.appendProperties(propertiesToBeAdded: Map<String, String>) {
        val propertySeparator = detectPropertiesSeparatorInFileContent(this)

        val content =
            propertiesToBeAdded
                .map { (key, value) -> "$key$propertySeparator$value" }
                .sorted()
                .joinToString(System.lineSeparator())

        if (shouldAddLineSeparatorAtStart(this)) {
            appendText(System.lineSeparator())
        }

        appendText(content)
    }

    fun detectSeparatorForProperties(line: String): String? {
        val matcher = Pattern.compile("\\s*[:=]\\s*").matcher(line)

        val separator = if (matcher.find()) matcher.group() else null

        return separator
    }

    private fun detectPropertiesSeparatorInFileContent(file: File): String {
        val lines = file.readLinesIfExists()

        return lines.firstNotNullOfOrNull { detectSeparatorForProperties(it) } ?: DEFAULT_SEPARATOR
    }

    private fun shouldAddLineSeparatorAtStart(file: File): Boolean {
        return file.exists() && file.readLines().last().isNotEmpty()
    }

    private fun String.parseProperty(): Pair<String, String>? {
        return byteInputStream().use { inputStream ->
            val properties = Properties()
            properties.load(inputStream)
            properties.map { it.key.toString() to it.value.toString() }.firstOrNull()
        }
    }

    private fun File.readLinesIfExists(): List<String> {
        if (!exists()) {
            log.debug("File ${this.absolutePath} does not exist. Returning empty file content")
            return emptyList()
        }
        return readLines()
    }

    private fun Pair<String, String>?.toMap(): Map<String, String> =
        if (this == null) emptyMap() else mapOf(this)

    companion object {
        private const val DEFAULT_SEPARATOR = "="
    }
}
