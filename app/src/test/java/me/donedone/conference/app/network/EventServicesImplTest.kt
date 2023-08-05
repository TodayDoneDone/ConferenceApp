package me.donedone.conference.app.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class EventServicesImplTest {

    @Before
    fun setUp() {
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getEventList() = runTest {
        val response = EventServicesImpl(client = HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }).getEventAll()
        advanceUntilIdle()
        Assert.assertNotNull(response)
        Assert.assertTrue((response?.rows?.size ?: 0) > 0)
    }
}