package com.example.fordogfans.ui.list

import com.example.fordogfans.network.DogService
import com.example.fordogfans.network.model.DogListResponse
import com.example.fordogfans.network.model.Message
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

internal class ListPresenterImplTest {

    @MockK
    private lateinit var mockService: DogService

    @MockK
    private lateinit var mockView: ListView

    @MockK
    private lateinit var mockDogListResponse: Response<DogListResponse>

    private lateinit var subject: ListPresenterImpl

    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        subject = ListPresenterImpl(mockService).also { it.setupView(mockView) }
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun getDogBreeds() {
        //given
        every { mockDogListResponse.isSuccessful } returns true
        every { mockDogListResponse.body() } returns DogListResponse(Message(), "success")
        coEvery { mockService.getBreedsList() } returns mockDogListResponse

        //when
        subject.getDogBreeds()

        //then
        coVerify { mockService.getBreedsList() }
        verify { mockView.onRetrievedDogBreeds(any()) }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}