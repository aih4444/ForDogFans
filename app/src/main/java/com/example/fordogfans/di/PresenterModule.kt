package com.example.fordogfans.di

import com.example.fordogfans.ui.detail.DetailPresenter
import com.example.fordogfans.ui.detail.DetailPresenterImpl
import com.example.fordogfans.ui.list.ListPresenter
import com.example.fordogfans.ui.list.ListPresenterImpl
import org.koin.dsl.module

    val presentersModule = module {
        single<DetailPresenter> { DetailPresenterImpl(get()) }
        single<ListPresenter> { ListPresenterImpl(get()) }
    }
