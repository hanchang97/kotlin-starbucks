package com.hanchang97.starbucks.usecase.home

import com.hanchang97.starbucks.repository.home.HomeRepository

class GetHomeInfoUseCase(private val homeRepository: HomeRepository) {
    suspend fun getHomeInfo() = homeRepository.getHomeInfo()
}