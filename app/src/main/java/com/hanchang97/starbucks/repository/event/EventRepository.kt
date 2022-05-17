package com.hanchang97.starbucks.repository.event

import com.hanchang97.starbucks.model.event.Event
import com.hanchang97.starbucks.network.event.EventService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EventRepository(private val eventService: EventService) {

    suspend fun getEventInfo(): Flow<Event> = flow {
        emit(eventService.getEventInfo())
    }.flowOn(Dispatchers.IO)


}