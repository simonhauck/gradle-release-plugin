package io.github.simonhauck.release.testdriver

import java.io.File
import java.nio.file.Paths


fun getTestResourceFile(resource: String): File {
    return Paths.get("src/test/resources").resolve(resource).toFile()
}
