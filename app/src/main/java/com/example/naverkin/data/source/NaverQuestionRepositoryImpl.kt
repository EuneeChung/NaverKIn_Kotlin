package com.example.naverkin.data.source

import com.example.naverkin.data.QuestionListResponse
import com.example.naverkin.data.source.remote.NaverQuestionRemoteDataSource

class NaverQuestionRepositoryImpl (private  val remoteDataSource: NaverQuestionRemoteDataSource):
        NaverQuestionRepository{
    override fun getSearch(
        clientId: String,
        clientSecret: String,
        query: String,
        onSuccess: (questionResponse: QuestionListResponse) -> Unit,
        onFail: (errorMsg: String) -> Unit
    ) {
        remoteDataSource.getSearch(query = query,onFail = onFail,onSuccess = onSuccess)
    }

}