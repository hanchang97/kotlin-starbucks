package com.hanchang97.starbucks.model.home.homeinfo


import com.google.gson.annotations.SerializedName

data class HomeInfo(
    @SerializedName("display-name")
    val displayName: String? = "",
    @SerializedName("main-event")
    val mainEvent: MainEvent? = MainEvent(),
    @SerializedName("now-recommand")
    val nowRecommand: NowRecommand? = NowRecommand(),
    @SerializedName("your-recommand")
    val yourRecommand: YourRecommand? = YourRecommand()
)