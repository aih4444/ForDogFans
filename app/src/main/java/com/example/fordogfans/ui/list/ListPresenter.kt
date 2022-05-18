package com.example.fordogfans.ui.list

import com.example.fordogfans.ui.base.BasePresenter

abstract class ListPresenter: BasePresenter<ListView>() {

    abstract fun getDogBreeds()
}