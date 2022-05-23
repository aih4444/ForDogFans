package com.example.fordogfans.network

import retrofit2.Response

sealed class UseCaseResult<out T>{
    data class Success<T>(val response: Response<T>): UseCaseResult<T>()
    data class Error<T>(val message:String? = null, val response: Response<T>?): UseCaseResult<T>()
    object UnknownError: UseCaseResult<Nothing>()
}
