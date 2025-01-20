package io.github.simonhauck.release.git.internal.process

import io.github.simonhauck.release.util.Either
import io.github.simonhauck.release.util.getOrElse
import io.github.simonhauck.release.util.map

internal typealias ProcessResult = Either<ProcessError, ProcessSuccess>

internal fun ProcessResult.exitCode(): Int? = map { it.exitCode }.getOrElse { it.exitCode }

internal data class ProcessSuccess(val exitCode: Int, val output: List<String>)

internal data class ProcessError(
    val exitCode: Int?,
    val output: List<String>,
    val error: Throwable?,
    val message: String,
)
