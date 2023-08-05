package me.donedone.conference.app.network

import io.ktor.http.URLBuilder

object HttpRoutes {

    val GET_EVENT_All: URLBuilder.(URLBuilder) -> Unit = {
        this.host = "festa.io"
        this.encodedPath = "/api/v1/events"
        this.parameters.apply {
            append("page", "1")
            append("pageSize", "100")
            append("order", "startDate")
            append("excludeExternalEvents", "false")
        }
    }
}