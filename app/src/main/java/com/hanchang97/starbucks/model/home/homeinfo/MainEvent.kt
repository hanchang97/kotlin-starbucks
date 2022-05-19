package com.hanchang97.starbucks.model.home.homeinfo


import com.google.gson.annotations.SerializedName

data class MainEvent(
    @SerializedName("img_UPLOAD_PATH")
    val imgUPLOADPATH: String? = "",
    @SerializedName("mob_THUM")
    val mobTHUM: String? = ""
)