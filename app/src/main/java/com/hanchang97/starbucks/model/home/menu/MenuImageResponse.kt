package com.hanchang97.starbucks.model.home.menu


import com.google.gson.annotations.SerializedName

data class MenuImageResponse(
    @SerializedName("file")
    val file: List<MenuImage>? = listOf()
)