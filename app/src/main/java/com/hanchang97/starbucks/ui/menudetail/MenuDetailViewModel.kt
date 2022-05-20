package com.hanchang97.starbucks.ui.menudetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanchang97.starbucks.common.ApiState
import com.hanchang97.starbucks.database.MenuDao
import com.hanchang97.starbucks.database.MenuEntity
import com.hanchang97.starbucks.model.home.menu.MenuData
import com.hanchang97.starbucks.model.home.menu.MenuImage
import com.hanchang97.starbucks.model.home.menu.MenuInfo
import com.hanchang97.starbucks.usecase.menu.GetMenuImageUseCase
import com.hanchang97.starbucks.usecase.menu.GetMenuInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MenuDetailViewModel(
    private val getMenuInfoUseCase: GetMenuInfoUseCase,
    private val getMenuImageUseCase: GetMenuImageUseCase,
    private val menuDao: MenuDao
) : ViewModel() {

    private val _menuInfoStateFlow: MutableStateFlow<ApiState<MenuInfo>> =
        MutableStateFlow(ApiState.Empty)
    val menuInfoStateFlow: StateFlow<ApiState<MenuInfo>> = _menuInfoStateFlow

    private val _menuImageStateFlow: MutableStateFlow<ApiState<MenuImage>> =
        MutableStateFlow(ApiState.Empty)
    val menuImageStateFlow: StateFlow<ApiState<MenuImage>> = _menuImageStateFlow

    private val _isLikeStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLikeStateFlow: StateFlow<Boolean> = _isLikeStateFlow

    private var Product_Cd: String? = ""
    private var Menu_Name: String? = ""
    private var Menu_Name_Eng: String? = ""
    private var Menu_Image_Url: String? = ""


    fun getMenuInfo(product_cd: String) {
        viewModelScope.launch {
            _menuInfoStateFlow.value = ApiState.Loading
            getMenuInfoUseCase.getMenuInfo(product_cd)
                .catch { e ->
                    _menuInfoStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.menuInfo?.let {
                        _menuInfoStateFlow.value = ApiState.Success(it)

                        Product_Cd = it.product_CD
                        Menu_Name = it.product_NM
                        Menu_Name_Eng = it.product_ENGNM
                    }
                }
        }
    }

    fun getMenuImage(product_cd: String) {
        viewModelScope.launch {
            _menuImageStateFlow.value = ApiState.Loading
            getMenuImageUseCase.getMenuImage(product_cd)
                .catch { e ->
                    _menuImageStateFlow.value = ApiState.Error(e.message)
                }.collect { data ->
                    data.file?.let {
                        if (it.size != 0) {
                            _menuImageStateFlow.value = ApiState.Success(it[0])

                            Menu_Image_Url = it[0].imgUPLOADPATH + it[0].filePATH
                        }
                    }
                }
        }
    }

    fun checkMenu(product_cd: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val boolean = menuDao.isMenuExist(product_cd)
            Log.d("AppTest", "isExist : ${boolean}")

            _isLikeStateFlow.value = boolean
        }
    }

    fun addMenu() {
        Log.d("AppTest", "addMenu")
        viewModelScope.launch(Dispatchers.IO) {
            Product_Cd?.let {
                if (it.length > 0) {
                    menuDao.insertMenu(MenuEntity(Product_Cd!!, Menu_Name!!, Menu_Name_Eng!!, Menu_Image_Url!!))
                    checkMenu(Product_Cd!!)
                }
            }
        }
    }

    fun deleteMenu(){
        Log.d("AppTest", "deleteMenu")
        viewModelScope.launch(Dispatchers.IO) {
            Product_Cd?.let {
                if (it.length > 0) {
                    menuDao.deleteMenu(MenuEntity(Product_Cd!!, Menu_Name!!, Menu_Name_Eng!!, Menu_Image_Url!!))
                    checkMenu(Product_Cd!!)
                }
            }
        }
    }

    fun touchLikeBtn(){
        if(_isLikeStateFlow.value) deleteMenu()
        else addMenu()
    }
}