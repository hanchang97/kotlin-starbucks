package com.hanchang97.starbucks.network.home

import com.hanchang97.starbucks.model.home.eventall.EventAllResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HomeEventService {
    @FormUrlEncoded
    @POST("whats_new/getIngList.do")
    suspend fun getEventList(
        @Field("MENU_CD") menu_cd: String  // "all" 이 고정값으로 들어간다
    ): EventAllResponse

}