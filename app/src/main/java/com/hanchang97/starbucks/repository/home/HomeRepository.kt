package com.hanchang97.starbucks.repository.home

import com.hanchang97.starbucks.model.home.eventall.EventAllResponse
import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.network.home.HomeEventService
import com.hanchang97.starbucks.network.home.HomeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRepository(private val homeService: HomeService, private val homeEventService: HomeEventService) {

    suspend fun getHomeInfo(): Flow<HomeInfo> = flow {
        emit(homeService.getHomeInfo())
    }.flowOn(Dispatchers.IO)

    suspend fun getEventList(): Flow<EventAllResponse> = flow {
        emit(homeEventService.getEventList("all"))
    }.flowOn(Dispatchers.IO)
}