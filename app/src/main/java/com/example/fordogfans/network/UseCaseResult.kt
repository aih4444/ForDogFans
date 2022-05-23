package com.example.fordogfans.network

sealed class UseCaseResult<out T>{
    data class Success<T>(val value: T): UseCaseResult<T>()
    data class Error<T>(val message:String? = null, val value: T?): UseCaseResult<T>()
    object UnknownError: UseCaseResult<Nothing>()
}
