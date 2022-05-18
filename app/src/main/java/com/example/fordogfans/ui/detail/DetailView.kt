package com.example.fordogfans.ui.detail

import com.example.fordogfans.ui.base.BaseView

interface DetailView : BaseView {

    fun onRetrievedDogImageUrls(imagesUrls: List<String>)
}