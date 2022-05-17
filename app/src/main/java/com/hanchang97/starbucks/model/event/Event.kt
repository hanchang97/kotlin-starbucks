package com.hanchang97.starbucks.model.event


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("event-products")
    val eventProducts: String? = "",
    @SerializedName("range")
    val range: String? = "",
    @SerializedName("target")
    val target: String? = "",
    @SerializedName("title")
    val title: String? = ""
)