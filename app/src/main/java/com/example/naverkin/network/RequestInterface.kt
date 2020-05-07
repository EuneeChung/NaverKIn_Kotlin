package com.example.naverkin.network

import com.example.naverkin.data.RvQuestionListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface RequestInterface {


    @GET("/v1/search/kin.xml")
    fun getSearchQuestion(
        @Header("X-Naver-Client-Id")clientId:String="8H4arYz4sHMDVSXAfAsR",
        @Header("X-Naver-Client-Sevret")clientSecret:String="94_l1vCIzp",
        @Query("query",encoded = true)query:String

    ): Call<RvQuestionListResponse>


}