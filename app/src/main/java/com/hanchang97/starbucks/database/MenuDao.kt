package com.hanchang97.starbucks.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {

    @Query("SELECT * FROM menuentity")  // 모든 데이터, 버스 정류장 도착 시간 오름차순으로 표시하기 위함
    fun getAll(): Flow<List<MenuEntity>>

    @Insert
    fun insertMenu(menuEntity: MenuEntity)

    @Delete
    fun deleteMenu(menuEntity: MenuEntity)

    @Query("SELECT EXISTS(SELECT * FROM menuentity WHERE product_cd = :product_cd)")
    fun isMenuExist(product_cd: String) : Boolean
}