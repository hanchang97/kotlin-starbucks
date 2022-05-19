package com.hanchang97.starbucks.ui.eventall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.home.eventall.EventInfo
import com.hanchang97.starbucks.usecase.home.GetHomeEventListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EventAllViewModel(private val getHomeEventListUseCase: GetHomeEventListUseCase) :
    ViewModel() {

    private val _eventAllInfoListStateFlow: MutableStateFlow<ApiState<List<EventInfo>>> =
        MutableStateFlow(ApiState.Empty)
    val eventAllInfoListStateFlow: StateFlow<ApiState<List<EventInfo>>> =
        _eventAllInfoListStateFlow

    fun getEventAllList() {
        viewModelScope.launch {
            _eventAllInfoListStateFlow.value = ApiState.Loading
            getHomeEventListUseCase.getHomeEventList()
                .catch { e ->
                    _eventAllInfoListStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.list?.let {
                        _eventAllInfoListStateFlow.value = ApiState.Success(it)
                    }
                }
        }
    }
}