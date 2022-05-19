package com.hanchang97.starbucks.repository.menu

import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.model.home.menu.MenuImageResponse
import com.hanchang97.starbucks.model.home.menu.MenuInfoResponse
import com.hanchang97.starbucks.network.home.HomeMenuService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MenuRepository(private val homeMenuService: HomeMenuService) {

    suspend fun getMenuInfo(product_cd: String): Flow<MenuInfoResponse> = flow {
        emit(homeMenuService.getMenuInfo(product_cd))
    }.flowOn(Dispatchers.IO)

    suspend fun getMenuImage(product_cd: String): Flow<MenuImageResponse> = flow {
        emit(homeMenuService.getMenuImage(product_cd))
    }.flowOn(Dispatchers.IO)

}