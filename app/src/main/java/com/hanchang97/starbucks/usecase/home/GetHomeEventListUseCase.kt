package com.hanchang97.starbucks.usecase.home

import com.hanchang97.starbucks.repository.home.HomeRepository

class GetHomeEventListUseCase(private val homeRepository: HomeRepository) {
    suspend fun getHomeEventList() = homeRepository.getEventList()
}