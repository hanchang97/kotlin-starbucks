package com.hanchang97.starbucks.model.whatsnew


import com.google.gson.annotations.SerializedName

data class WhatsNewResponse(
    @SerializedName("cnt")
    val cnt: Int? = 0,
    @SerializedName("list")
    val list: List<WhatsNewInfo>? = listOf(),
    @SerializedName("vo")
    val vo: Vo? = Vo()
)