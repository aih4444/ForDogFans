package com.example.fordogfans.network.model

import com.google.gson.annotations.SerializedName

data class RandomDogImagesResponse(
    @SerializedName("message" ) var imageUrls : List<String>? = emptyList(),
    @SerializedName("status"  ) var status  : String?  = null
)
