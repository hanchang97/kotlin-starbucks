package com.hanchang97.starbucks.model.home.menu

import com.google.gson.annotations.SerializedName

data class MenuInfoResponse(
    @SerializedName("view")
    val menuInfo: MenuInfo? = MenuInfo()
)
