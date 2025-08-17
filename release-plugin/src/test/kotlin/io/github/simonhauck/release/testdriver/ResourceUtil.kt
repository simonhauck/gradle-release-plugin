package io.github.simonhauck.release.testdriver

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.attribute.PosixFilePermission
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

fun getTestResourceFile(resource: String): File {
    return Paths.get("src/test/resources").resolve(resource).toFile()
}

fun getRSAPublicKey(): File {
    return getTestResourceFile("ssh-key/id_rsa.pub")
}

fun getRSAPublicKey2(): File {
    return getTestResourceFile("ssh-key/id_rsa2.pub")
}

fun getRSAKeyInTempDirectoryWithCorrectPermissions(tmpDir: File): File {
    return getTestResourceFile("ssh-key/id_rsa").copyTo(tmpDir.resolve("id_rsa")).apply {
        if (
            DefaultNativePlatform.getCurrentOperatingSystem().isLinux ||
                DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX
        ) {
            Files.setPosixFilePermissions(
                toPath(),
                setOf(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE),
            )
        }
    }
}

fun getRSA2KeyInTempDirectoryWithCorrectPermissions(tmpDir: File): File {
    return getTestResourceFile("ssh-key/id_rsa").copyTo(tmpDir.resolve("id_rsa")).apply {
        setReadable(true, true)
        setWritable(true, true)
        setExecutable(false)
    }
}
