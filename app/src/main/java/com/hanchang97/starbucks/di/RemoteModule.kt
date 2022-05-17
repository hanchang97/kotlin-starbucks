package com.hanchang97.starbucks.di

import com.hanchang97.starbucks.common.Common
import com.hanchang97.starbucks.network.event.EventService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal val remoteModule = module {
    single(named("event")) { provideRetrofitBuilder(Common.eventBaseUrl)}
    single(named("statbucks")) { provideRetrofitBuilder(Common.starBucksBaseUrl)}

    single { provideEventService(get(named("event"))) }

}

internal fun provideRetrofitBuilder(baseUrl: String) = Retrofit.Builder()
    .client(provideOkhttpClient())
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

internal fun provideOkhttpClient() = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    })
    .build()

internal fun provideEventService(retrofit: Retrofit) = retrofit.create(EventService :: class.java)