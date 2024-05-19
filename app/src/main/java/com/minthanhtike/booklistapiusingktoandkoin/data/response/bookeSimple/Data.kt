package com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("books")
    val books: List<Book?>?
)