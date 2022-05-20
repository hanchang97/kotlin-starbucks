package com.hanchang97.starbucks.ui.main.tab.favorite

import androidx.lifecycle.ViewModel
import com.hanchang97.starbucks.database.MenuDao
import com.hanchang97.starbucks.database.MenuEntity
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(private val menuDao: MenuDao): ViewModel() {

    fun getAllFavoriteMenu(): Flow<List<MenuEntity>> = menuDao.getAll()
}