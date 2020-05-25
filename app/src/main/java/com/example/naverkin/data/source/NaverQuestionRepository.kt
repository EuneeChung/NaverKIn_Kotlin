package com.example.naverkin.data.source

import com.example.naverkin.data.QuestionListResponse

interface NaverQuestionRepository {
    //구글 문서에서 DataSource // Repository
    fun getSearch(clientId:String="CUsno_MHATn82KNlJGbW",
                  clientSecret:String="jOiHT4f3F1",
                  query:String,
                  onSuccess: (questionResponse: QuestionListResponse) -> Unit,
                  onFail: (errorMsg : String) -> Unit)
}