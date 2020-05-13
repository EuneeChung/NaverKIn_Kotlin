package com.example.naverkin.ui.questionList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naverkin.data.QuestionListResponse
import com.example.naverkin.R
import com.example.naverkin.network.RequestURL
import com.example.naverkin.data.RvQuestionListResponseItems
import kotlinx.android.synthetic.main.activity_question.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionActivity : AppCompatActivity() {
    private lateinit var rvQuestionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        View.AccessibilityDelegate()



        rv_question.layoutManager=LinearLayoutManager(this)
        rvQuestionListAdapter= QuestionListAdapter(this)
        rv_question.adapter=rvQuestionListAdapter
        rvQuestionListAdapter.notifyDataSetChanged()


        btn_quesstion.setOnClickListener {
           getQuestionListResponse()
            Log.e("","버튼 눌렀다")
            rvQuestionListAdapter.notifyDataSetChanged()
        }


    }

    private fun getQuestionListResponse(){
        val call:Call<QuestionListResponse> = RequestURL.service.getSearchQuestion(query = edt_question.text.toString())
        System.clearProperty("X-Naver-Client-Id")
        System.clearProperty("X-Naver-Client-Secret")
        call.enqueue(
            object:Callback<QuestionListResponse>{
                override fun onFailure(call: Call<QuestionListResponse>, t: Throwable) {
                    Log.e("getQuestionResponse",t.toString())
                }

                override fun onResponse(
                    call: Call<QuestionListResponse>,
                    response: Response<QuestionListResponse>
                ) {
                    val questionList= response.body()?.items
                    if(response.isSuccessful){
                        if(questionList!=null) {
                            rvQuestionListAdapter.data = questionList
                            Log.e("",questionList.toString())
                            Log.e("",questionList[0].toString())
                            Log.e("",rvQuestionListAdapter.data.toString())
                            Log.e("",rvQuestionListAdapter.data[0].link.toString())
                            rvQuestionListAdapter.notifyDataSetChanged()
                        }
                    }
                }

            }

        )

    }
}
