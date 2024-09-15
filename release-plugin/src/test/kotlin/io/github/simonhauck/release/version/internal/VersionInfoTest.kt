package io.github.simonhauck.release.version.internal

import io.github.simonhauck.release.version.api.Version
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.gradle.api.GradleException
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class VersionInfoTest {

    private val validPairs =
        listOf(
            "1.0.0" to VersionInfo(1, 0, 0),
            "0.0.4" to VersionInfo(0, 0, 4),
            "1.2.3" to VersionInfo(1, 2, 3),
            "10.20.30" to VersionInfo(10, 20, 30),
            "1.1.2-prerelease+meta" to VersionInfo(1, 1, 2, "prerelease", "meta"),
            "1.1.2+meta" to VersionInfo(1, 1, 2, buildMetaData = "meta"),
            "1.1.2+meta-valid" to VersionInfo(1, 1, 2, buildMetaData = "meta-valid"),
            "1.0.0-alpha" to VersionInfo(1, 0, 0, "alpha"),
            "1.0.0-beta" to VersionInfo(1, 0, 0, "beta"),
            "1.0.0-alpha.beta" to VersionInfo(1, 0, 0, "alpha.beta"),
            "1.0.0-alpha.beta.1" to VersionInfo(1, 0, 0, "alpha.beta.1"),
            "1.0.0-alpha.1" to VersionInfo(1, 0, 0, "alpha.1"),
            "1.0.0-alpha0.valid" to VersionInfo(1, 0, 0, "alpha0.valid"),
            "1.0.0-alpha.0valid" to VersionInfo(1, 0, 0, "alpha.0valid"),
            "1.0.0-alpha-a.b-c-somethinglong+build.1-aef.1-its-okay" to
                VersionInfo(1, 0, 0, "alpha-a.b-c-somethinglong", "build.1-aef.1-its-okay"),
            "1.0.0-rc.1+build.1" to VersionInfo(1, 0, 0, "rc.1", "build.1"),
            "2.0.0-rc.1+build.123" to VersionInfo(2, 0, 0, "rc.1", "build.123"),
            "1.2.3-beta" to VersionInfo(1, 2, 3, "beta"),
            "10.2.3-DEV-SNAPSHOT" to VersionInfo(10, 2, 3, "DEV-SNAPSHOT"),
            "1.2.3-SNAPSHOT-123" to VersionInfo(1, 2, 3, "SNAPSHOT-123"),
            "1.0.0" to VersionInfo(1, 0, 0),
            "2.0.0" to VersionInfo(2, 0, 0),
            "1.1.7" to VersionInfo(1, 1, 7),
            "2.0.0+build.1848" to VersionInfo(2, 0, 0, buildMetaData = "build.1848"),
            "2.0.1-alpha.1227" to VersionInfo(2, 0, 1, "alpha.1227"),
            "1.0.0-alpha+beta" to VersionInfo(1, 0, 0, "alpha", "beta"),
            "1.2.3----RC-SNAPSHOT.12.9.1--.12+788" to
                VersionInfo(1, 2, 3, "---RC-SNAPSHOT.12.9.1--.12", "788"),
            "1.2.3----R-S.12.9.1--.12+meta" to VersionInfo(1, 2, 3, "---R-S.12.9.1--.12", "meta"),
            "1.2.3----RC-SNAPSHOT.12.9.1--.12" to
                VersionInfo(1, 2, 3, "---RC-SNAPSHOT.12.9.1--.12"),
            "1.0.0+0.build.1-rc.10000aaa-kk-0.1" to
                VersionInfo(1, 0, 0, buildMetaData = "0.build.1-rc.10000aaa-kk-0.1"),
            "9999.9999.9999" to VersionInfo(9999, 9999, 9999),
            "1.0.0-0A.is.legal" to VersionInfo(1, 0, 0, "0A.is.legal"),
        )

    @TestFactory
    fun isPreReleaseTests(): List<DynamicTest> =
        listOf("SNAPSHOT" to true, null to false).map {
            DynamicTest.dynamicTest("isPreRelease() should map ${it.first} to ${it.second}") {
                isPreRelease(it.first, it.second)
            }
        }

    private fun isPreRelease(preReleaseSuffix: String?, expected: Boolean) {
        val versionInfo = VersionInfo(1, 0, 0, preReleaseSuffix)

        val actual = versionInfo.isPreRelease()

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should remove the pre release suffix`() {
        val originalVersion = VersionInfo(1, 0, 0, "suffix")

        val actual = originalVersion.dropPreReleaseSuffix()

        assertThat(actual).isEqualTo(VersionInfo(1, 0, 0))
    }

    @Test
    fun `should increase the patch level by one and remove the pre release modifier on a patch release`() {
        val currentVersion = VersionInfo(1, 2, 3, preReleaseSuffix = "val")

        val actual = currentVersion.bumpPatch()

        val expected = VersionInfo(1, 2, 4)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should set the new pre release suffix`() {
        val currentVersion = VersionInfo(1, 2, 3, preReleaseSuffix = "val")

        val actual = currentVersion.bumpPatch("newPreReleaseSuffix")

        val expected = VersionInfo(1, 2, 4, "newPreReleaseSuffix")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should bump the minor version and reset the patch level`() {
        val currentVersion = VersionInfo(1, 2, 3, preReleaseSuffix = "val")

        val actual = currentVersion.bumpMinor("newPreReleaseSuffix")

        val expected = VersionInfo(1, 3, 0, "newPreReleaseSuffix")
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should bump the major version and reset minor and patch levels`() {
        val currentVersion = VersionInfo(1, 2, 3, preReleaseSuffix = "val")

        val actual = currentVersion.bumpMajor("newPreReleaseSuffix")

        val expected = VersionInfo(2, 0, 0, "newPreReleaseSuffix")
        assertThat(actual).isEqualTo(expected)
    }

    @TestFactory
    fun shouldCorrectlyBuildTheVersion(): List<DynamicTest> {
        return validPairs.map {
            DynamicTest.dynamicTest("should build from ${it.second} the version ${it.first}") {
                shouldBuildVersionCorrectly(it.second, it.first)
            }
        }
    }

    private fun shouldBuildVersionCorrectly(versionInfo: VersionInfo, expected: String) {
        val actual = versionInfo.toVersion()

        assertThat(actual).isEqualTo(Version(expected))
    }

    @TestFactory
    fun shouldParseVersionInfoCorrectlyTests(): List<DynamicTest> {
        return validPairs.map {
            DynamicTest.dynamicTest("should parse ${it.first} correctly to ${it.second}") {
                shouldParseVersionInfoCorrectly(it.first, it.second)
            }
        }
    }

    private fun shouldParseVersionInfoCorrectly(versionValue: String, expected: VersionInfo) {
        val actual = VersionInfo.fromVersion(Version(versionValue))

        assertThat(actual).isEqualTo(expected)
    }

    @TestFactory
    fun shouldThrowForInvalidFormatsTests(): List<DynamicTest> =
        listOf(
                "1",
                "1",
                "1.2",
                "1.2.3-0123",
                "1.2.3-0123.0123",
                "1.1.2+.123",
                "+invalid",
                "-invalid",
                "-invalid+invalid",
                "-invalid.01",
                "alpha",
                "alpha.beta",
                "alpha.beta.1",
                "alpha.1",
                "alpha+beta",
                "alpha_beta",
                "alpha.",
                "alpha..",
                "beta",
                "1.0.0-alpha_beta",
                "-alpha.",
                "1.0.0-alpha..",
                "1.0.0-alpha..1",
                "1.0.0-alpha...1",
                "1.0.0-alpha....1",
                "1.0.0-alpha.....1",
                "1.0.0-alpha......1",
                "1.0.0-alpha.......1",
                "01.1.1",
                "1.01.1",
                "1.1.01",
                "a.b.c",
                "1.2",
                "1.2.3.DEV",
                "1.2-SNAPSHOT",
                "1.2.31.2.3----RC-SNAPSHOT.12.09.1--..12+788",
                "1.2-RC-SNAPSHOT",
                "-1.0.3-gamma+b7718",
                "+justmeta",
                "9.8.7+meta+meta",
                "9.8.7-whatever+meta+meta",
                "9999.9999.9999----RC-SNAPSHOT.12.09.1--------------------------------..12",
            )
            .map { DynamicTest.dynamicTest("should fail parsing for $it") { expectsException(it) } }

    private fun expectsException(versionValue: String) {
        assertThatThrownBy { VersionInfo.fromVersion(Version(versionValue)) }
            .isInstanceOf(GradleException::class.java)
            .hasMessage(
                "Can not parse versionInfo of '$versionValue' since it does not conform to the SemVer pattern"
            )
    }
}
