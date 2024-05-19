package com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("author")
    val author: Author?,
    @SerialName("book_cover")
    val bookCover: String?,
    @SerialName("category")
    val category: Category?,
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("price")
    val price: Double?,
    @SerialName("rating")
    val rating: Double?
)