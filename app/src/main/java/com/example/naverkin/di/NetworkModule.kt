package com.example.naverkin.di

import com.example.naverkin.network.RequestNerworkInterface
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val NAVER_KIN_URL="https://openapi.naver.com"

val networkModule= module {
    single { (get() as Retrofit).create(RequestNerworkInterface::class.java) }

    single {
        Retrofit.Builder()
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .client(get())
            .baseUrl(NAVER_KIN_URL)
            .build()
    }

    single { GsonConverterFactory.create() as Converter.Factory }
    single { RxJava2CallAdapterFactory.create() as CallAdapter.Factory}
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                val originRequest = chain.request()
                val newRequest = originRequest.newBuilder()
                    .method(originRequest.method(), originRequest.body())
                    .build()
                chain.proceed(newRequest)
            }
            .build() as OkHttpClient
    }
}