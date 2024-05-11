package com.github.simonhauck.release.git.internal.process

import java.io.File

internal data class ProcessConfig(
    val environment: Map<String, String> = emptyMap(),
    val workingDir: File? = null
)
