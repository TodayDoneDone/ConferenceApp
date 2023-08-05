package me.donedone.conference.app.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.donedone.conference.app.network.EventServices
import me.donedone.conference.app.network.entity.ApiResult
import me.donedone.conference.app.network.entity.Response

class EventRepository(private val eventServices: EventServices = EventServices.create()) {

    fun getEventAll(): Flow<ApiResult<Response>> =
        flow {
            val response: Response? = eventServices.getEventAll()
            if (response == null) {
                emit(ApiResult.Error())
                return@flow
            }
            emit(ApiResult.Success(response))
        }
}