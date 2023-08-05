package me.donedone.conference.app.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import me.donedone.conference.app.network.EventServices
import me.donedone.conference.app.network.entity.ApiResult
import me.donedone.conference.app.network.entity.Response
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class EventRepositoryTest {

    private lateinit var mockService: EventServices
    private lateinit var repository: EventRepository

    @Before
    fun setup() {
        mockService = mock(EventServices::class.java)
        repository = EventRepository(mockService)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetEventAll_success() = runTest {
        val response = Response()
       `when`(mockService.getEventAll()).thenReturn(response)

        val apiResult = repository.getEventAll().single()
        advanceUntilIdle()
        Assert.assertTrue(apiResult is ApiResult.Success<Response>)
        apiResult as ApiResult.Success<Response>
        Assert.assertEquals(response, apiResult.value)
    }
}