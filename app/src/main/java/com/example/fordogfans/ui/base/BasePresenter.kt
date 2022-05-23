package com.example.fordogfans.ui.base

abstract class BasePresenter<V:BaseView> {
    lateinit var view: V

    open fun setupView(view: V){
        this.view = view
    }
}