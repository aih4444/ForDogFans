package com.example.fordogfans.ui.detail

import com.example.fordogfans.ui.base.BasePresenter

abstract class DetailPresenter: BasePresenter<DetailView>() {

     abstract fun getRandomImagesOfBreed(dogBreedName: String)
}