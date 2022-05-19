package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.ui.eventall.EventAllViewModel
import com.hanchang97.starbucks.ui.main.MainViewModel
import com.hanchang97.starbucks.ui.main.tab.home.HomeViewModel
import com.hanchang97.starbucks.ui.main.tab.order.OrderViewModel
import com.hanchang97.starbucks.ui.menudetail.MenuDetailViewModel
import com.hanchang97.starbucks.ui.whatsnew.WhatsNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


internal val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get(), get(), get(), get()) }
    viewModel { WhatsNewViewModel(get()) }
    viewModel { EventAllViewModel(get()) }
    viewModel { OrderViewModel() }
    viewModel { MenuDetailViewModel(get(), get()) }
}
