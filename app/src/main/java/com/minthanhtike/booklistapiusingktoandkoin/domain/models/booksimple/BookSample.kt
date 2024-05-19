package com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple


data class BookSample(
    val author: Authors,
    val bookCover: String,
    val category: Category,
    val description: String,
    val id: String,
    val name: String,
    val price: Double,
    val rating: Double
)

data class Authors(
    val description: String,
    val id: String,
    val name: String
)

data class Category(
    val categoryName: String,
    val id: String
)


