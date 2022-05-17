package com.hanchang97.starbucks.network.event

import com.hanchang97.starbucks.model.event.Event
import retrofit2.http.GET

interface EventService {

    @GET("starbuckst-loading.json")
    suspend fun getEventInfo(): Event
}