package com.example.fordogfans.network.model

import com.google.gson.annotations.SerializedName

data class DogListResponse(
    @SerializedName("message" ) var dogBreeds : Message? = Message(),
    @SerializedName("status"  ) var status  : String?  = null
)
