package com.github.simonhauck.git.process

import java.io.File

internal data class ProcessConfig(
    val environment: Map<String, String> = emptyMap(),
    val workingDir: File? = null
)
