package com.example.fordogfans.di

import com.example.fordogfans.network.DogService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { provideRetrofit() }
    single { provideService(get()) }
}

fun provideRetrofit() = Retrofit.Builder().baseUrl("https://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
fun provideService(retrofit: Retrofit) = retrofit.create(DogService::class.java)