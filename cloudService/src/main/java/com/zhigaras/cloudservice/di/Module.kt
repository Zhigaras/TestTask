package com.zhigaras.cloudservice.di

import com.zhigaras.cloudservice.HotelsApi
import com.zhigaras.cloudservice.HotelsCloudService
import com.zhigaras.cloudservice.HotelsCloudServiceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun cloudServiceModule() = module {
    
    factory {
        Retrofit.Builder()
            .baseUrl(HotelsApi.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    
    factory { get<Retrofit>().create(HotelsApi::class.java) } bind HotelsApi::class
    
    factory { HotelsCloudServiceImpl(get()) } bind HotelsCloudService::class
}