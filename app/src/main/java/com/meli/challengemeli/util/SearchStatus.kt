package com.meli.challengemeli.util

sealed class SearchStatus {
    object Loading : SearchStatus()
    data class Success<T>(val data: T) : SearchStatus()
    data class Error(val error: Throwable) : SearchStatus()
}
