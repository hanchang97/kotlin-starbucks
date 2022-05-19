package com.hanchang97.starbucks.network.home

import com.hanchang97.starbucks.model.home.menu.MenuImageResponse
import com.hanchang97.starbucks.model.home.menu.MenuInfoResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HomeMenuService {

    @FormUrlEncoded
    @POST("menu/productViewAjax.do")
    suspend fun getMenuInfo(
        @Field("product_cd") product_cd: String
    ): MenuInfoResponse

    @FormUrlEncoded
    @POST("menu/productFileAjax.do")
    suspend fun getMenuImage(
        @Field("PRODUCT_CD") product_cd: String
    ): MenuImageResponse
}