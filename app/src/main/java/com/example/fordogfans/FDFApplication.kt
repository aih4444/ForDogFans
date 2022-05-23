package com.example.fordogfans

import android.app.Application
import com.example.fordogfans.di.presentersModule
import com.example.fordogfans.di.retrofitModule
import com.example.fordogfans.di.usecasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FDFApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FDFApplication)
            modules(presentersModule, retrofitModule, usecasesModule)
        }
    }
}