package com.example.naverkin.data.source.remote

import com.example.naverkin.data.QuestionListResponse
import com.example.naverkin.data.source.NaverQuestionRepository
import com.example.naverkin.network.RequestNerworkInterface
import retrofit2.Callback
import retrofit2.Response

class NaverQuestionRemoteDataSourceImpl(private val naverApi:RequestNerworkInterface) :
    NaverQuestionRemoteDataSource {
    override fun getSearch(
        clientId: String,
        clientSecret: String,
        query:String,
        onSuccess: (questionResponse: QuestionListResponse) -> Unit,
        onFail: (errorMsg: String) -> Unit
    ) {
        naverApi
            .getSearchQuestion(query=query)
            .enqueue(object: Callback<QuestionListResponse>{
                override fun onFailure(call: retrofit2.Call<QuestionListResponse>, t: Throwable) {
                    onFail(t.toString())
                }

                override fun onResponse(
                    call: retrofit2.Call<QuestionListResponse>,
                    response: Response<QuestionListResponse>
                ) {
                    when(response.isSuccessful){
                        true-> response.body()?.let(onSuccess)
                        false->onFail(response.errorBody().toString())
                    }
                }

            })

    }


}