package com.example.naverkin.ui.questionList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naverkin.QuestionViewModel
import com.example.naverkin.R
import com.example.naverkin.data.source.NaverQuestionRepository
import com.example.naverkin.databinding.ActivityQuestionBinding
import kotlinx.android.synthetic.main.activity_question.*
import org.koin.android.ext.android.inject

class QuestionActivity : AppCompatActivity() {
    private val repository: NaverQuestionRepository by inject()
    private lateinit var  binding: ActivityQuestionBinding

    private lateinit var rvQuestionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_question)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_question)

        binding.activity = this // <- 이거 layout에서 activity 정의해줘서
        binding.edtQuestion.setText("바인딩")


       /* binding.btnQuesstion.setOnClickListener {
            getQuestionListResponse()
            Log.e("","버튼 눌렀다")
            rvQuestionListAdapter.notifyDataSetChanged()
        }*/

        rv_question.layoutManager=LinearLayoutManager(this)
        rvQuestionListAdapter= QuestionListAdapter(this)

        //rv_question.adapter=rvQuestionListAdapter
        binding.rvQuestion.adapter=rvQuestionListAdapter

        rvQuestionListAdapter.notifyDataSetChanged()
        //View.AccessibilityDelegate()




       /*
       btn_quesstion.setOnClickListener {
           getQuestionListResponse()
            Log.e("","버튼 눌렀다")
            rvQuestionListAdapter.notifyDataSetChanged()
        }
        */


    }



    private fun getQuestionListResponse(){

        repository.getSearch(query=edt_question.text.toString(),
          onSuccess = {
              val questionList= it.items
              rvQuestionListAdapter.data = questionList
              Log.e("",questionList.toString())
              Log.e("",questionList[0].toString())
              Log.e("",rvQuestionListAdapter.data.toString())
              Log.e("",rvQuestionListAdapter.data[0].link.toString())
              rvQuestionListAdapter.notifyDataSetChanged()
          },
            onFail={})

        /* val call:Call<QuestionListResponse> = RequestURL.SERVICE.getSearchQuestion(query = edt_question.text.toString())
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

        */
    }
    fun buttonClicked(){
        getQuestionListResponse()
        Log.e("df","fds")
    }
}
