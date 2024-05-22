package io.github.simonhauck.release.git.internal.process

import arrow.core.Either
import arrow.core.getOrElse

internal typealias ProcessResult = Either<ProcessError, ProcessSuccess>

internal fun ProcessResult.exitCode(): Int? = map { it.exitCode }.getOrElse { it.exitCode }

internal data class ProcessSuccess(val exitCode: Int, val output: List<String>)

internal data class ProcessError(
    val exitCode: Int?,
    val output: List<String>,
    val error: Throwable,
    val message: String
)
