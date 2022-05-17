package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
