package com.example.fordogfans.usecase

import com.example.fordogfans.network.UseCaseResult
import org.koin.core.component.KoinComponent

interface BaseUseCase<R>: KoinComponent {
   suspend fun execute():UseCaseResult<R>?
}