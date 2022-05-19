package com.hanchang97.starbucks.ui.main.tab.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.model.home.menu.MenuData
import com.hanchang97.starbucks.usecase.home.GetHomeInfoUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuImageUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuInfoUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeInfoUseCase: GetHomeInfoUseCase,
    private val getMenuInfoUseCase: GetMenuInfoUseCase,
    private val getMenuImageUseCase: GetMenuImageUseCase
) : ViewModel() {

    private val _homeInfoStateFlow: MutableStateFlow<ApiState<HomeInfo>> =
        MutableStateFlow(ApiState.Empty)
    val homeInfoStateFlow: StateFlow<ApiState<HomeInfo>> = _homeInfoStateFlow

    private var recommand_your_count = 0
    private var recommand_now_count = 0

    private val _menuRecommandYouList: MutableStateFlow<List<MenuData>> = MutableStateFlow(listOf())
    val menuRecommandYouList: StateFlow<List<MenuData>> = _menuRecommandYouList

    fun getHomeInfo() {
        viewModelScope.launch {
            _homeInfoStateFlow.value = ApiState.Loading
            getHomeInfoUseCase.getHomeInfo()
                .catch { e ->
                    _homeInfoStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    _homeInfoStateFlow.value = ApiState.Success(data)
                    data.yourRecommand?.products?.let {
                        getRecommandYouData(it)
                    }
                }
        }
    }

    fun getRecommandYouData(productCdList: List<String>) {
        recommand_your_count = productCdList.size
        Log.d("AppTest", "productCdList : ${productCdList}")
        Log.d("AppTest", "recommand your count : ${recommand_your_count}")
        val menuDataList = List(recommand_your_count) { MenuData() }

        viewModelScope.launch {
            (0..recommand_your_count - 1).map {
                async {
                    getMenuInfoUseCase.getMenuInfo(productCdList[it])
                        .catch { e ->
                            Log.d("AppTest", "get recommand you menu info error, ${e}")
                        }.collect { data ->
                            menuDataList[it].menuInfo = data.menuInfo
                            Log.d("AppTest", "index : ${it}, ${menuDataList[it].menuInfo}")
                        }
                }

                async {
                    getMenuImageUseCase.getMenuImage(productCdList[it])
                        .catch { e ->
                            Log.d("AppTest", "get recommand you menu image error, ${e}")
                        }.collect { data ->
                            val inx = it
                            data.file?.let {
                                if (it.size != 0) menuDataList[inx].menuImage = it.get(0)
                            }
                        }
                }
            }.awaitAll()


            val removeNullList = arrayListOf<MenuData>()
            menuDataList.forEach {
                if (it.menuInfo != null) {
                    removeNullList.add(it)
                    Log.d("AppTest", "add")
                }
            }
            Log.d("AppTest", "remove null list size : ${removeNullList.size}")

            _menuRecommandYouList.value = removeNullList
        }
    }

}