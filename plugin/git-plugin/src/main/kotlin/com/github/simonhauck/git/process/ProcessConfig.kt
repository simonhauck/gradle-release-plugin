package com.github.simonhauck.git.process

import java.io.File

// TODO Simon.Hauck 2024-05-05 - this should be internal because the plugin should not care how this
// is executed
data class ProcessConfig(
    val environment: Map<String, String> = emptyMap(),
    val workingDir: File? = null
)
