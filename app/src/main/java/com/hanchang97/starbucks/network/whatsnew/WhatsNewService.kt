package com.hanchang97.starbucks.network.whatsnew

import com.hanchang97.starbucks.model.whatsnew.WhatsNewResponse
import retrofit2.http.GET

interface WhatsNewService {
    @GET("whats_new/newsListAjax.do")
    suspend fun getWhatsNewList(): WhatsNewResponse
}