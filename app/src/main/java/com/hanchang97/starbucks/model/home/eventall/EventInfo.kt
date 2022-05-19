package com.hanchang97.starbucks.model.home.eventall

import com.google.gson.annotations.SerializedName

data class EventInfo(
    @SerializedName("mob_THUM")
    val mobTHUM: String? = "",
    @SerializedName("sbtitle_NAME")
    val sbtitleNAME: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("web_THUM")
    val webTHUM: String? = ""
)
