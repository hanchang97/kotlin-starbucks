package com.hanchang97.starbucks.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MenuEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao

}