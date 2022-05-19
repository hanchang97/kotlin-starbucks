package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.usecase.event.GetEventInfoUseCase
import com.hanchang97.starbucks.usecase.home.GetHomeInfoUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuImageUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuInfoUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { GetEventInfoUseCase(get()) }
    factory { GetHomeInfoUseCase(get()) }

    factory { GetMenuInfoUseCase(get()) }
    factory { GetMenuImageUseCase(get()) }


}