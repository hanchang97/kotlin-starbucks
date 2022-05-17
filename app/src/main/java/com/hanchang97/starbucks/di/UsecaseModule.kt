package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.usecase.event.GetEventInfoUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { GetEventInfoUseCase(get()) }
}