package com.minthanhtike.booklistapiusingktoandkoin.di

import com.minthanhtike.booklistapiusingktoandkoin.data.networkService.ApiService
import com.minthanhtike.booklistapiusingktoandkoin.data.repository.BookSampleRepo
import com.minthanhtike.booklistapiusingktoandkoin.presentation.viewmodel.BookSampleViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteModule = module {
    single {
        HttpClient(Android) {
            defaultRequest {
                url(" http://54.179.102.152/api/")
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(Logging){
                logger= Logger.ANDROID
                level=LogLevel.BODY
            }
        }
    }

    single { ApiService(get()) }

    single { BookSampleRepo(get()) }

    viewModel { BookSampleViewModel(get()) }
}