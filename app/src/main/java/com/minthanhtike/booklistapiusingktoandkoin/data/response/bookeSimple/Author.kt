package com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)