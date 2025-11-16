package com.example.newsfeed.domain.uscase

import com.example.newsfeed.domain.data.HeadlineData
import com.example.newsfeed.domain.repository.HeadlineRepository
import io.mockk.MockK
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HeadlineListUseCaseTest {
    private val repository: HeadlineRepository = mockk()
    private val useCase = HeadlineListUseCase(repository)

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }


    @Test
    fun `Loading then Success`() = runTest {
//        val mockList = mockk<List<HeadlineData>>()

        val mockList = listOf(
            HeadlineData(
                headline = "Title",
                description = "Description",
                imageUrl = "https://img.com",
                url = "https://url.com"
            )
        )

        coEvery { repository.getHeadlines() } returns mockList

        val a = useCase().take(2).toList()
        assertTrue(a[0] is Resource.Loading)
        assertTrue(a[1] is Resource.Success)
    }

    @Test
    fun `Loading then Error`() = runTest {
        //val mockList = mockk<List<HeadlineData>>()
        coEvery { repository.getHeadlines() } throws Exception("Network error")

        val a = useCase().take(2).toList()
        assertTrue(a[0] is Resource.Loading)
        assertTrue(a[1] is Resource.Error)
    }


}