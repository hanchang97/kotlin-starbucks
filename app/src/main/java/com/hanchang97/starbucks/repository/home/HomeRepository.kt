package com.hanchang97.starbucks.repository.home

import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.network.home.HomeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HomeRepository(private val homeService: HomeService) {

    suspend fun getHomeInfo(): Flow<HomeInfo> = flow {
        emit(homeService.getHomeInfo())
    }.flowOn(Dispatchers.IO)
}