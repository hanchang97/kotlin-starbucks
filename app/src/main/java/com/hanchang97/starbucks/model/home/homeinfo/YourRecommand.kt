package com.hanchang97.starbucks.model.home.homeinfo


import com.google.gson.annotations.SerializedName

data class YourRecommand(
    @SerializedName("products")
    val products: List<String>? = listOf()
)