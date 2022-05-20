package com.hanchang97.starbucks.di

import android.app.Application
import androidx.room.Room
import com.hanchang97.starbucks.database.AppDatabase
import com.hanchang97.starbucks.database.MenuDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

internal val databaseModule = module {
    fun provideDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "menu.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: AppDatabase): MenuDao {
        return dataBase.menuDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}