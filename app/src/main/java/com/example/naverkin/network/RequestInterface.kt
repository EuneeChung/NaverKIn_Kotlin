package com.example.naverkin.network


import com.example.naverkin.data.QuestionListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface RequestInterface {


    @GET("/v1/search/kin.json")
    fun getSearchQuestion(
        @Header("X-Naver-Client-Id")clientId:String="CUsno_MHATn82KNlJGbW",
        @Header("X-Naver-Client-Secret")clientSecret:String="jOiHT4f3F1",
        @Query("query")query:String

    ): Call<QuestionListResponse>


}