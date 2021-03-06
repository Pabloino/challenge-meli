package com.meli.challengemeli.util

sealed class Status<T> {
    class Loading<T> : Status<T>()
    data class Success<T>(val data: T) : Status<T>()
    data class Error<T>(val error: Throwable) : Status<T>()
}
