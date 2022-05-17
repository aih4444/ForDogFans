package com.example.fordogfans.ui.detail

interface DetailPresenter {

     fun setView(view: DetailView)
     fun getRandomImagesOfBreed(dogBreedName: String)
}