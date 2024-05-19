package com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple


import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.Authors
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.BookSample
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookSimpleDto(
    @SerialName("code")
    val code: Int?,
    @SerialName("data")
    val data: Data?,
    @SerialName("message")
    val message: String?
)

fun BookSimpleDto.toDomain(): List<BookSample> {

    return this.data?.books?.map {
        BookSample(
            author = it?.author.let { author ->
                Authors(
                    description = author?.description.orEmpty(),
                    id = author?.id!!,
                    name = author.name.orEmpty()
                )
            },
            bookCover = it?.bookCover.orEmpty(),
            category = it?.category.let {category ->
                Category(
                    categoryName = category?.categoryName.orEmpty(),
                    id = category?.id!!
                )
            },
            description = it?.description.orEmpty(),
            id = it?.id!!,
            name = it.name.orEmpty(),
            price = it.price!! ,
            rating = it.rating!!
        )
    } ?: listOf()
}