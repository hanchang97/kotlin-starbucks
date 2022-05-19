package com.hanchang97.starbucks.ui.menudetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.home.menu.MenuData
import com.hanchang97.starbucks.model.home.menu.MenuImage
import com.hanchang97.starbucks.model.home.menu.MenuInfo
import com.hanchang97.starbucks.usecase.menu.GetMenuImageUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MenuDetailViewModel(
    private val getMenuInfoUseCase: GetMenuInfoUseCase,
    private val getMenuImageUseCase: GetMenuImageUseCase
) : ViewModel() {

    private val _menuInfoStateFlow: MutableStateFlow<ApiState<MenuInfo>> = MutableStateFlow(ApiState.Empty)
    val menuInfoStateFlow: StateFlow<ApiState<MenuInfo>> = _menuInfoStateFlow

    private val _menuImageStateFlow: MutableStateFlow<ApiState<MenuImage>> = MutableStateFlow(ApiState.Empty)
    val menuImageStateFlow: StateFlow<ApiState<MenuImage>> = _menuImageStateFlow

    fun getMenuInfo(product_cd: String){
        viewModelScope.launch {
            _menuInfoStateFlow.value = ApiState.Loading
            getMenuInfoUseCase.getMenuInfo(product_cd)
                .catch { e ->
                    _menuInfoStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.menuInfo?.let {
                        _menuInfoStateFlow.value = ApiState.Success(it)
                    }
                }
        }
    }

    fun getMenuImage(product_cd: String){
        viewModelScope.launch {
            _menuImageStateFlow.value = ApiState.Loading
            getMenuImageUseCase.getMenuImage(product_cd)
                .catch { e ->
                    _menuImageStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.file?.let {
                        if (it.size != 0) _menuImageStateFlow.value = ApiState.Success(it[0])
                    }
                }
        }
    }

}