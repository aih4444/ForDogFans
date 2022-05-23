package com.example.fordogfans.di

import com.example.fordogfans.network.DogService
import com.example.fordogfans.ui.list.GetDogBreedsListUseCase
import org.koin.dsl.module

val usecasesModule = module {
    single { provideUseCase(get()) }
}

private fun provideUseCase(service: DogService) = GetDogBreedsListUseCase(service)