package com.example.naverkin.data.source.remote

import com.example.naverkin.data.QuestionListResponse

interface NaverQuestionRemoteDataSource {
    fun getSearch(clientId:String="CUsno_MHATn82KNlJGbW",
                  clientSecret:String="jOiHT4f3F1",
                  query:String,
                  onSuccess: (questionResponse: QuestionListResponse) -> Unit,
                  onFail: (errorMsg : String) -> Unit)

}