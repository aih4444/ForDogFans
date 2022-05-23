package com.example.fordogfans.ui.list

import com.example.fordogfans.network.UseCaseResult.Error
import com.example.fordogfans.network.UseCaseResult.Success
import com.example.fordogfans.network.UseCaseResult.UnknownError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

class ListPresenterImpl(
    private val getDogBreedsListUseCase: GetDogBreedsListUseCase
) : ListPresenter(), KoinComponent {
    override fun setupView(view: ListView) {
        this.view = view
    }

    override fun getDogBreeds() {
        CoroutineScope(Dispatchers.Main).launch {
            val useCaseResult = getDogBreedsListUseCase.execute()
            withContext(Dispatchers.Main) {
                when (useCaseResult) {
                    is Success -> {
                        view.onRetrievedDogBreeds(useCaseResult.value)
                    }
                    is Error -> TODO()
                    UnknownError -> TODO()
                }
            }
        }
    }
}