package com.hanchang97.starbucks.repository.whatsnew

import com.hanchang97.starbucks.model.whatsnew.WhatsNewResponse
import com.hanchang97.starbucks.network.whatsnew.WhatsNewService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WhatsNewRepository(private val whatsNewService: WhatsNewService) {
    suspend fun getWhatsNewList(): Flow<WhatsNewResponse> = flow {
        emit(whatsNewService.getWhatsNewList())
    }.flowOn(Dispatchers.IO)
}