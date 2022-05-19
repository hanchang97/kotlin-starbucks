package com.hanchang97.starbucks.model.event


import com.google.gson.annotations.SerializedName

// 앱 시작 시 초기 이벤트 창 관련 데이터
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