package com.example.fordogfans.ui.detail

import android.util.Log
import com.example.fordogfans.network.DogService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class DetailPresenterImpl(private val service: DogService) : DetailPresenter() {

    override fun setupView(view: DetailView) {
        this.view = view
    }

    override fun getRandomImagesOfBreed(dogBreedName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getRandomImagesOfBreed(breed = dogBreedName)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val dogBreedList = response.body()?.imageUrls
                        view.onRetrievedDogImageUrls(dogBreedList ?: emptyList())
                    }
                } catch (exception: HttpException) {
                    Log.d("TAG", "getRandomImagesOfBreed: ${exception.printStackTrace()}")
                }
            }
        }
    }
}