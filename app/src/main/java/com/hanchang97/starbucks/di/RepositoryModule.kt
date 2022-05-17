package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.repository.event.EventRepository
import org.koin.dsl.module


internal val repositoryModule = module {

    single { EventRepository(get()) }


}