package com.hanchang97.starbucks.model.whatsnew

import com.google.gson.annotations.SerializedName

data class WhatsNewInfo(
    @SerializedName("img_nm")
    val imgNm: String? = "",
    @SerializedName("news_dt")
    val newsDt: String? = "",
    @SerializedName("sub_title_name")
    val subTitleName: String? = "",
    @SerializedName("title")
    val title: String? = ""
)
