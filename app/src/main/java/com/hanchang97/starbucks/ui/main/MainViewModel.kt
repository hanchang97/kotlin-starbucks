package com.hanchang97.starbucks.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.event.Event
import com.hanchang97.starbucks.usecase.event.GetEventInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val getEventInfoUseCase: GetEventInfoUseCase
    ): ViewModel() {

    private val _eventStateFlow: MutableStateFlow<ApiState<Event>> = MutableStateFlow(ApiState.Empty)
    val eventStateFlow: StateFlow<ApiState<Event>> = _eventStateFlow

    fun getEventInfo(){
        viewModelScope.launch {
            _eventStateFlow.value = ApiState.Loading
            getEventInfoUseCase.getEventInfo()
                .catch { e->
                    _eventStateFlow.value = ApiState.Error(e.message)
                }.collect{ data ->
                    _eventStateFlow.value = ApiState.Success(data)
                }
        }
    }


}