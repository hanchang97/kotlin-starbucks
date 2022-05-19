package com.hanchang97.starbucks.usecase.menu

import com.hanchang97.starbucks.repository.menu.MenuRepository

class GetMenuImageUseCase(private val menuRepository: MenuRepository) {
    suspend fun getMenuImage(product_cd: String) = menuRepository.getMenuImage(product_cd)
}