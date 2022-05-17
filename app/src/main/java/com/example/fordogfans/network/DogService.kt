package com.example.fordogfans.network

import com.example.fordogfans.network.model.DogListResponse
import com.example.fordogfans.network.model.RandomDogImagesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {

    @GET("breeds/list/all")
    suspend fun getBreedsList(): Response<DogListResponse>

    @GET("breed/{breed}/images/random/10")
    suspend fun getRandomImagesOfBreed(@Path("breed") breed:String): Response<RandomDogImagesResponse>
}