package com.hanchang97.starbucks.ui.main.tab.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.event.Event
import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.usecase.home.GetHomeInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val getHomeInfoUseCase: GetHomeInfoUseCase): ViewModel() {

    private val _homeInfoStateFlow: MutableStateFlow<ApiState<HomeInfo>> = MutableStateFlow(ApiState.Empty)
    val homeInfoStateFlow: StateFlow<ApiState<HomeInfo>> = _homeInfoStateFlow


    fun getHomeInfo(){
        viewModelScope.launch {
            _homeInfoStateFlow.value = ApiState.Loading
            getHomeInfoUseCase.getHomeInfo()
                .catch { e->
                    _homeInfoStateFlow.value = ApiState.Error(e.message)
                }.collect{ data ->
                    _homeInfoStateFlow.value = ApiState.Success(data)
                }
        }
    }

}