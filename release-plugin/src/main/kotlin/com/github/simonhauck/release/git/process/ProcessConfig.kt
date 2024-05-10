package com.github.simonhauck.release.git.process

import java.io.File

internal data class ProcessConfig(
    val environment: Map<String, String> = emptyMap(),
    val workingDir: File? = null
)
