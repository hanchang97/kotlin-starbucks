package com.hanchang97.starbucks.ui.main.tab.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.model.home.eventall.EventInfo
import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import com.hanchang97.starbucks.model.home.menu.MenuData
import com.hanchang97.starbucks.usecase.home.GetHomeEventListUseCase
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
    private val getMenuImageUseCase: GetMenuImageUseCase,
    private val getHomeEventListUseCase: GetHomeEventListUseCase
) : ViewModel() {

    private val _homeInfoStateFlow: MutableStateFlow<ApiState<HomeInfo>> =
        MutableStateFlow(ApiState.Empty)
    val homeInfoStateFlow: StateFlow<ApiState<HomeInfo>> = _homeInfoStateFlow

    private var recommand_your_count = 0
    private var recommand_now_count = 0

    private val _menuRecommandYouList: MutableStateFlow<List<MenuData>> = MutableStateFlow(listOf())
    val menuRecommandYouList: StateFlow<List<MenuData>> = _menuRecommandYouList

    private val _menuRecommandNowList: MutableStateFlow<List<MenuData>> = MutableStateFlow(listOf())
    val menuRecommandNowList: StateFlow<List<MenuData>> = _menuRecommandNowList

    private val _eventListStateFlow: MutableStateFlow<ApiState<List<EventInfo>>> =
        MutableStateFlow(ApiState.Empty)
    val eventListStateFlow: StateFlow<ApiState<List<EventInfo>>> = _eventListStateFlow


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
                    data.nowRecommand?.products?.let {
                        getRecommandNowData(it)
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
                            Log.d("AppTest", "you/ index : ${it}, ${menuDataList[it].menuInfo}")
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

    // 현재 시간대 인기 메뉴
    fun getRecommandNowData(productCdList: List<String>) {
        recommand_now_count = productCdList.size
        Log.d("AppTest", "productCdList : ${productCdList}")
        Log.d("AppTest", "recommand now count : ${recommand_now_count}")
        val menuDataList = List(recommand_now_count) { MenuData() }

        viewModelScope.launch {
            (0..recommand_now_count - 1).map {
                async {
                    getMenuInfoUseCase.getMenuInfo(productCdList[it])
                        .catch { e ->
                            Log.d("AppTest", "get recommand now menu info error, ${e}")
                        }.collect { data ->
                            menuDataList[it].menuInfo = data.menuInfo
                            Log.d("AppTest", "now/ index : ${it}, ${menuDataList[it].menuInfo}")
                        }
                }

                async {
                    getMenuImageUseCase.getMenuImage(productCdList[it])
                        .catch { e ->
                            Log.d("AppTest", "get recommand now menu image error, ${e}")
                        }.collect { data ->
                            val inx = it
                            data.file?.let {
                                if (it.size != 0) menuDataList[inx].menuImage = it.get(0)
                            }
                        }
                }
            }.awaitAll()


            var menuRank = 1
            val removeNullList = arrayListOf<MenuData>()
            menuDataList.forEach {
                if (it.menuInfo != null) {
                    removeNullList.add(it.also { it.rank = menuRank++ })
                    Log.d("AppTest", "add")
                }
            }
            Log.d("AppTest", "now/ remove null list size : ${removeNullList.size}")

            _menuRecommandNowList.value = removeNullList
        }
    }


    // 홈 화면 이벤트 리스트 가져오기 -> 홈 화면에서는 최대 4개 보이도록 하기!!
    fun getEventList() {
        viewModelScope.launch {
            _eventListStateFlow.value = ApiState.Loading

            getHomeEventListUseCase.getHomeEventList()
                .catch { e ->
                    _eventListStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.list?.let {
                        val eventList = arrayListOf<EventInfo>()
                        for (i in 0..3) {
                            if (i + 1 > it.size) break
                            eventList.add(it[i])
                        }
                        _eventListStateFlow.value = ApiState.Success(eventList)
                    }
                }
        }
    }

}