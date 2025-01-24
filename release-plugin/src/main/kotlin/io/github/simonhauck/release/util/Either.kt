package io.github.simonhauck.release.util

sealed class Either<out L, out R> {

    data class Left<out L>(val value: L) : Either<L, Nothing>()

    data class Right<out R>(val value: R) : Either<Nothing, R>()

    fun isLeft(): Boolean = this is Left<L>

    fun isRight(): Boolean = this is Right<R>
}

internal fun <L, R> Either<L, Either<L, R>>.flatten(): Either<L, R> =
    when (this) {
        is Either.Left -> this
        is Either.Right -> this.value
    }

internal fun <L, R> Either<L, R>.getOrElse(default: (L) -> R): R =
    when (this) {
        is Either.Left -> default(this.value)
        is Either.Right -> this.value
    }

internal fun <L, R> Either<L, R>.getOrNull(): R? =
    when (this) {
        is Either.Left -> null
        is Either.Right -> this.value
    }

internal fun <L> Either<L, *>.leftOrNull(): L? = (this as? Either.Left<L>)?.value

internal fun <L, R, T> Either<L, R>.map(transform: (R) -> T): Either<L, T> =
    when (this) {
        is Either.Left -> this
        is Either.Right -> Either.Right(transform(this.value))
    }

internal fun <L, R> Either<L, R>.onLeft(action: (L) -> Unit): Either<L, R> {
    if (this is Either.Left) action(this.value)
    return this
}

internal fun <L, R> Either<L, R>.onRight(action: (R) -> Unit): Either<L, R> {
    if (this is Either.Right) action(this.value)
    return this
}

internal fun <L, R, T> Either<L, R>.mapLeft(transform: (L) -> T): Either<T, R> =
    when (this) {
        is Either.Left -> Either.Left(transform(this.value))
        is Either.Right -> this
    }
