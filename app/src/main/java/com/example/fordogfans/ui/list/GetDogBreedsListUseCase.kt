package com.example.fordogfans.ui.list

import com.example.fordogfans.model.DogBreedList
import com.example.fordogfans.model.toDogBreedList
import com.example.fordogfans.network.DogService
import com.example.fordogfans.network.UseCaseResult
import com.example.fordogfans.network.UseCaseResult.Error
import com.example.fordogfans.network.UseCaseResult.Success
import com.example.fordogfans.network.model.DogListResponse
import com.example.fordogfans.usecase.BaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class GetDogBreedsListUseCase(private val service: DogService) : BaseUseCase<DogBreedList> {
    override suspend fun execute(): UseCaseResult<DogBreedList> =
        withContext(Dispatchers.IO) {
            val response: Response<DogListResponse> = service.getBreedsList()
            try {
                if (response.isSuccessful) {
                    response.body()?.dogBreeds?.let { Success(value = it.toDogBreedList()) }
                        ?: Error(value = null)
                } else {
                    Error(value = null)
                }
            } catch (exception: HttpException) {
                Error(message = exception.message(), value = null)
            }
        }
}