package com.hanchang97.starbucks.usecase.event

import com.hanchang97.starbucks.repository.event.EventRepository

class GetEventInfoUseCase(private val eventRepository: EventRepository) {

    suspend fun getEventInfo() = eventRepository.getEventInfo()
}