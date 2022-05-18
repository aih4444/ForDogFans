package com.example.fordogfans.ui.list

import com.example.fordogfans.model.DogBreedList
import com.example.fordogfans.ui.base.BaseView

interface ListView : BaseView {

    fun onRetrievedDogBreeds(dogBreeds: DogBreedList)
}