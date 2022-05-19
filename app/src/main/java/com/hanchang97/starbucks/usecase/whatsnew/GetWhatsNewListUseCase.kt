package com.hanchang97.starbucks.usecase.whatsnew

import com.hanchang97.starbucks.repository.whatsnew.WhatsNewRepository

class GetWhatsNewListUseCase(private val whatsNewRepository: WhatsNewRepository) {
    suspend fun getWhatsNewList() = whatsNewRepository.getWhatsNewList()
}