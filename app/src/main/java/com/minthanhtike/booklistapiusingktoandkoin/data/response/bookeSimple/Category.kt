package com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("category_name")
    val categoryName: String?,
    @SerialName("id")
    val id: String?
)
