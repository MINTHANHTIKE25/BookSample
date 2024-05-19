package com.minthanhtike.booklistapiusingktoandkoin.data.repository

import com.minthanhtike.booklistapiusingktoandkoin.R
import com.minthanhtike.booklistapiusingktoandkoin.data.networkService.ApiService
import com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple.BookSimpleDto
import com.minthanhtike.booklistapiusingktoandkoin.data.response.bookeSimple.toDomain
import com.minthanhtike.booklistapiusingktoandkoin.domain.Resources
import com.minthanhtike.booklistapiusingktoandkoin.domain.models.booksimple.BookSample
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException

class BookSampleRepo(
    private val remoteDataSource: ApiService
) {
    suspend fun getBookSample(): Resources<List<BookSample>> {
        val apiRespond = remoteDataSource.getBookSimple()
        return try{
            val result=apiRespond.toDomain()
            Resources.Success(result)
        } catch (e:ClientRequestException) {
            val errorMsg= e.localizedMessage ?: ""
            Resources.Error(errorMsg)
        }catch (e:ServerResponseException){
            val errorMsg=e.localizedMessage ?: ""
            Resources.Error(errorMsg)
        }catch (e:Exception){
            Resources.Error(e.localizedMessage ?: "An Unknown Error occurs")
        }
    }
}

