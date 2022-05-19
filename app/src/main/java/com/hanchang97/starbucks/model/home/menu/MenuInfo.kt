package com.hanchang97.starbucks.model.home.menu

import com.google.gson.annotations.SerializedName

data class MenuInfo(
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("product_CD")
    val product_CD: String? = "",
    @SerializedName("product_NM")
    val product_NM: String? = "",
    @SerializedName("product_ENGNM")
    val product_ENGNM: String? = "",
)
