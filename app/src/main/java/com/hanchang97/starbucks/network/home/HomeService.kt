package com.hanchang97.starbucks.network.home

import com.hanchang97.starbucks.model.home.homeinfo.HomeInfo
import retrofit2.http.GET

interface HomeService {

    @GET("starbuckst")
    suspend fun getHomeInfo(): HomeInfo
}