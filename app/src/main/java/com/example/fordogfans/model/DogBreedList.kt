package com.example.fordogfans.model

import android.util.Log
import com.example.fordogfans.network.model.Message
import kotlin.reflect.full.declaredMemberProperties

data class DogBreedList(var breeds: List<Breed> = arrayListOf())

fun Message.toDogBreedList(): DogBreedList {
    var dogBreedList = DogBreedList()
    for (property in (this::class.declaredMemberProperties)) {
        val breed = Breed(property.name, property.getter.call(this) as List<String>)
        dogBreedList.breeds += breed
    }
    Log.d("TAG", "toDogBreedList: $dogBreedList ")
    return dogBreedList
}
