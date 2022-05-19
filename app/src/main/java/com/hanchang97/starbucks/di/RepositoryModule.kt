package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.repository.event.EventRepository
import com.hanchang97.starbucks.repository.home.HomeRepository
import org.koin.dsl.module


internal val repositoryModule = module {

    single { EventRepository(get()) }
    single { HomeRepository(get()) }

}