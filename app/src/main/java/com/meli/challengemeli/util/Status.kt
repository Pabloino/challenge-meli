package com.meli.challengemeli.util

sealed class Status {
    object Loading : Status()
    data class Success<T>(val data: T) : Status()
    data class Error(val error: Throwable) : Status()
}
