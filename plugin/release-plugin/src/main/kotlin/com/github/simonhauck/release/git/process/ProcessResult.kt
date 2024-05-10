package com.github.simonhauck.release.git.process

import arrow.core.Either

internal typealias ProcessResult = Either<ProcessError, ProcessSuccess>

internal data class ProcessSuccess(val exitCode: Int, val output: List<String>)

internal data class ProcessError(
    val exitCode: Int?,
    val output: List<String>,
    val error: Throwable,
    val message: String
)
