package com.minthanhtike.booklistapiusingktoandkoin.domain

sealed class Resources<T> {
    data class Success<T>(val success:T):Resources<T>()
    data class Error<T>(val error: String):Resources<T>()
}