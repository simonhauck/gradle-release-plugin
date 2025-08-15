package io.github.simonhauck.release.file.internal

import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.io.TempDir

class PropertiesFileUtilTest {

    @TempDir lateinit var tempDir: File

    @Test
    fun `should read valid properties from the file`() {
        val file =
            tempDir.resolve("test.properties").apply {
                writeText(
                    """
                    |someProperty=value
                    |
                    |someOtherProperty=anotherValue
                    |propertyWithOtherSeparator: dot
                    |    whiteSpace: yes
                    |
                    |#comment=this should be filtered
                    """
                        .trimMargin()
                )
            }

        val actual = PropertiesFileUtil().readProperties(file)

        val expected =
            mapOf(
                "someProperty" to "value",
                "someOtherProperty" to "anotherValue",
                "propertyWithOtherSeparator" to "dot",
                "whiteSpace" to "yes",
            )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should create the property file and write the properties if not existing`() {
        val file = tempDir.resolve("test.properties")

        val properties = mapOf("someProperty" to "value", "someOtherProperty" to "anotherValue")

        PropertiesFileUtil().updatePropertiesFile(file, properties)

        val actual = file.readLines()

        val expected = listOf("someOtherProperty=anotherValue", "someProperty=value")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should add missing and update existing properties without deleting comments or unrelated properties`() {
        val file =
            tempDir.resolve("test.properties").apply {
                writeText(
                    """
                    |someProperty=value
                    |# Some comment
                    |someOtherProperty=anotherValue
                    """
                        .trimMargin()
                )
            }

        val properties =
            mapOf("newProperty" to "newValue", "someProperty" to "somePropertyNewValue")

        PropertiesFileUtil().updatePropertiesFile(file, properties)

        val actual = file.readLines()

        val expected =
            listOf(
                "someProperty=somePropertyNewValue",
                "# Some comment",
                "someOtherProperty=anotherValue",
                "newProperty=newValue",
            )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `updating a properties file should use the pre-existing property separator`() {
        val file =
            tempDir.resolve("test.properties").apply {
                writeText(
                    """
                    |someProperty: value
                    |someOtherProperty: anotherValue
                    """
                        .trimMargin()
                )
            }

        val properties =
            mapOf("someProperty" to "somePropertyNewValue", "newProperty" to "newValue")

        PropertiesFileUtil().updatePropertiesFile(file, properties)

        val actual = file.readLines()

        val expected =
            listOf(
                "someProperty: somePropertyNewValue",
                "someOtherProperty: anotherValue",
                "newProperty: newValue",
            )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should add a line separator at the start of the file if it is missing`() {
        val file =
            tempDir.resolve("test.properties").apply {
                writeText(
                    """
                    |someProperty=value
                    """
                        .trimMargin()
                )
            }

        val properties = mapOf("newProperty" to "newValue")

        PropertiesFileUtil().updatePropertiesFile(file, properties)

        val actual = file.readLines()

        val expected = listOf("someProperty=value", "newProperty=newValue")
        assertThat(actual).isEqualTo(expected)
    }

    @TestFactory
    fun shouldDetectPropertiesSeparatorTests(): List<DynamicTest> =
        listOf(
                "someProperty = value" to " = ",
                "someProperty=value" to "=",
                "someProperty= value" to "= ",
                "  someProperty = value" to " = ",
                "someProperty:value" to ":",
                "someProperty : value" to " : ",
                "someProperty: value" to ": ",
                "  someProperty : value" to " : ",
            )
            .map {
                DynamicTest.dynamicTest(
                    "shouldDetectPropertiesSeparator() should map ${it.first} to ${it.second}"
                ) {
                    shouldDetectPropertiesSeparator(it.first, it.second)
                }
            }

    @Test
    fun `should return null if no separator can be detected`() {
        val actual = PropertiesFileUtil().detectSeparatorForProperties("")

        assertThat(actual).isEqualTo(null)
    }

    @Test
    fun `should respect empty lines in the property file when updating`() {
        val file =
            tempDir.resolve("test.properties").apply {
                writeText(
                    """
                    |someProperty=value
                    |
                    |someOtherProperty=anotherValue
                    |
                    |#comment=this should be filtered
                    """
                        .trimMargin()
                )
            }

        val properties = mapOf("someOtherProperty" to "newValue")

        PropertiesFileUtil().updatePropertiesFile(file, properties)

        val actual = file.readLines()

        val expected =
            listOf(
                "someProperty=value",
                "",
                "someOtherProperty=newValue",
                "",
                "#comment=this should be filtered",
            )
        assertThat(actual).isEqualTo(expected)
    }

    private fun shouldDetectPropertiesSeparator(fileContent: String, expected: String) {
        val actual = PropertiesFileUtil().detectSeparatorForProperties(fileContent)

        assertThat(actual).isEqualTo(expected)
    }
}
