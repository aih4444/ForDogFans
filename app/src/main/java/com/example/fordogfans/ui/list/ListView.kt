package com.example.fordogfans.ui.list

import com.example.fordogfans.model.DogBreedList

interface ListView {

    fun onRetrievedDogBreeds(dogBreeds: DogBreedList)
}