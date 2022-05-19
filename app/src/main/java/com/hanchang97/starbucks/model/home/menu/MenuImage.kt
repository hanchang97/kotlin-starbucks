package com.hanchang97.starbucks.model.home.menu


import com.google.gson.annotations.SerializedName

data class MenuImage(
    @SerializedName("file_PATH")
    val filePATH: String? = "",
    @SerializedName("img_UPLOAD_PATH")
    val imgUPLOADPATH: String? = "",
)