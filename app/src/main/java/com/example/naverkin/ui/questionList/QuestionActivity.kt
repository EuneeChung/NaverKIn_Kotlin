package com.example.naverkin.ui.questionList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naverkin.R
import com.example.naverkin.data.RvQuestionListResponse
import com.example.naverkin.network.RequestURL
import kotlinx.android.synthetic.main.activity_question.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionActivity : AppCompatActivity() {
    private lateinit var rvQuestionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        rv_question_list.layoutManager=LinearLayoutManager(this)
        rvQuestionListAdapter= QuestionListAdapter(this)
        rv_question_list.adapter=rvQuestionListAdapter
        rvQuestionListAdapter.data= listOf(
            RvQuestionListResponse(
                "dfs",
                "dfsf",
                "dfds"
            )
        )
        rvQuestionListAdapter.notifyDataSetChanged()
        btn_quesstion.setOnClickListener(){
            getQuestionListResponse()
        }

    }

    private fun getQuestionListResponse(){
        val call:Call<RvQuestionListResponse> = RequestURL.service.getSearchQuestion(edt_question.text.toString())
        call.enqueue(
            object:Callback<RvQuestionListResponse>{
                override fun onFailure(call: Call<RvQuestionListResponse>, t: Throwable) {
                    Log.e("getQuestionResponse",t.toString())
                }

                override fun onResponse(
                    call: Call<RvQuestionListResponse>,
                    response: Response<RvQuestionListResponse>
                ) {
                    val questionList= mutableListOf<RvQuestionListResponse>()
                    if(response.isSuccessful){

                        for(item in questionList){
                            questionList.add(
                                RvQuestionListResponse(
                                    item.title,
                                    item.link,
                                    item.descripption
                                )
                            )
                        }
                        rvQuestionListAdapter.data=questionList
                        rvQuestionListAdapter.notifyDataSetChanged()
                    }
                }

            }

        )

    }
}
