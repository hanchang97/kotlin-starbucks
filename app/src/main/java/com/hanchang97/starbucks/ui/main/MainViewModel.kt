package com.hanchang97.starbucks.ui.main

import androidx.lifecycle.ViewModel
import com.hanchang97.starbucks.repository.event.EventRepositoy
import com.hanchang97.starbucks.usecase.event.GetEventInfoUseCase

class MainViewModel(
    private val getEventInfoUseCase: GetEventInfoUseCase
    ): ViewModel() {


}