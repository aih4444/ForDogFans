package com.example.fordogfans.ui.detail

import com.example.fordogfans.network.DogService
import com.example.fordogfans.network.model.RandomDogImagesResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class DetailPresenterImplTest {

    @MockK
    private lateinit var mockService: DogService

    @MockK
    private lateinit var mockView: DetailView

    @MockK
    private lateinit var mockResponse: Response<RandomDogImagesResponse>

    private lateinit var subject: DetailPresenterImpl

    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        subject = DetailPresenterImpl(mockService).also { it.setupView(mockView) }
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun getRandomImagesOfBreed() {
        //given
        every { mockResponse.isSuccessful } returns true
        every { mockResponse.body() } returns RandomDogImagesResponse(emptyList(), "success")
        coEvery { mockService.getRandomImagesOfBreed(any()) } returns mockResponse
        
        //when
        subject.getRandomImagesOfBreed("hound")

        //then
        coVerify { mockService.getRandomImagesOfBreed(any()) }
        verify { mockView.onRetrievedDogImageUrls(any()) }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}