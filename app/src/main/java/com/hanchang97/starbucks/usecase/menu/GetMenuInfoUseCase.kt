package com.hanchang97.starbucks.usecase.menu

import com.hanchang97.starbucks.repository.menu.MenuRepository

class GetMenuInfoUseCase(private val menuRepository: MenuRepository) {
    suspend fun getMenuInfo(product_cd: String) = menuRepository.getMenuInfo(product_cd)
}