package me.donedone.conference.app.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import me.donedone.conference.app.network.HttpRoutes.GET_EVENT_All
import me.donedone.conference.app.network.entity.Response

class EventServicesImpl(
    private val client: HttpClient
) : EventServices {
    private val TAG = this.javaClass.simpleName

    override suspend fun getEventAll(): Response? {
        return try {
            client.get {
                this.url(GET_EVENT_All)
            }
        } catch (e: RedirectResponseException) {
            // 3xx responses
            Log.e(TAG, "Error : ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx responses
            Log.e(TAG, "Error : ${e.response.status.description}")
            null
        } catch(e: ServerResponseException) {
            // 5xx responses
            Log.e(TAG, "Error : ${e.response.status.description}")
            null
        } catch(e: Exception) {
            Log.e(TAG, "Error : ${e.message}")
            null
        }
    }
}