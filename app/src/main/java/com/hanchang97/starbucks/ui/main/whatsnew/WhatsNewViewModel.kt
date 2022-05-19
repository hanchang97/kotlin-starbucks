package com.hanchang97.starbucks.ui.main.whatsnew

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.event.Event
import com.hanchang97.starbucks.model.whatsnew.WhatsNewInfo
import com.hanchang97.starbucks.model.whatsnew.WhatsNewResponse
import com.hanchang97.starbucks.usecase.whatsnew.GetWhatsNewListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class WhatsNewViewModel(private val getWhatsNewListUseCase: GetWhatsNewListUseCase) : ViewModel() {

    private val _whatsNewInfoListStateFlow: MutableStateFlow<ApiState<List<WhatsNewInfo>>> =
        MutableStateFlow(ApiState.Empty)
    val whatsNewInfoListStateFlow: StateFlow<ApiState<List<WhatsNewInfo>>> =
        _whatsNewInfoListStateFlow

    fun getWhatsNewList() {
        viewModelScope.launch {
            _whatsNewInfoListStateFlow.value = ApiState.Loading
            getWhatsNewListUseCase.getWhatsNewList()
                .catch { e ->
                    _whatsNewInfoListStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.list?.let {
                        _whatsNewInfoListStateFlow.value = ApiState.Success(it)
                    }
                }
        }
    }
}