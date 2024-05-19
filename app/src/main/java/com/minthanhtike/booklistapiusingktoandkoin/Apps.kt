package com.minthanhtike.booklistapiusingktoandkoin

import android.app.Application
import com.minthanhtike.booklistapiusingktoandkoin.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Apps :Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Apps)
            modules(remoteModule)
        }
    }
}