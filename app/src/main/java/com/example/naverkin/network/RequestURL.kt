package com.example.naverkin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestURL {

    private const val BASE_URL="https://openapi.naver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val SERVICE : RequestNerworkInterface = retrofit.create(
        RequestNerworkInterface::class.java)
}