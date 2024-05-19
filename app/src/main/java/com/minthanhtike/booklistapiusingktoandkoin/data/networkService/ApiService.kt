package com.minthanhtike.booklistapiusingktoandkoin.data.networkService

import com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple.BookSimpleDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClient: HttpClient) {

    suspend fun getBookSimple() = httpClient.get("user/books_simple").body<BookSimpleDto>()
}
