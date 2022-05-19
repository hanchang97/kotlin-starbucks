package com.hanchang97.starbucks.model.home.eventall


import com.google.gson.annotations.SerializedName

data class EventAllResponse(
    @SerializedName("list")
    val list: List<EventInfo>? = listOf()
)