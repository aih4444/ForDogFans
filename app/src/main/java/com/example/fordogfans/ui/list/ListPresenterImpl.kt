package com.example.fordogfans.ui.list

import com.example.fordogfans.model.DogBreedList
import com.example.fordogfans.model.toDogBreedList
import com.example.fordogfans.network.DogService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import retrofit2.HttpException

class ListPresenterImpl(private val service: DogService) : ListPresenter(), KoinComponent {
    override fun setupView(view: ListView) {
        this.view = view
    }

    override fun getDogBreeds() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getBreedsList()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val dogBreedList = response.body()?.dogBreeds?.toDogBreedList()
                        view.onRetrievedDogBreeds(dogBreedList ?: DogBreedList())
                    }
                } catch (exception: HttpException) {
                    exception.printStackTrace()
                }
            }
        }
    }
}