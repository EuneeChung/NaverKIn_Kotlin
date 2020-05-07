package com.example.naverkin.ui.questionList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverkin.R
import com.example.naverkin.data.RvQuestionListResponse

class QuestionListAdapter(private val context: Context)  : RecyclerView.Adapter<QuestionListHolder>() {

    var data = listOf<RvQuestionListResponse>()
    private lateinit var onclick: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionListHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.rv_question_list,parent,false)
       // view.setOnClickListener(onclick)
        return QuestionListHolder(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: QuestionListHolder, position: Int) {
       holder.bind(data[position])
    }
    fun setOnClick(i:View.OnClickListener){
        onclick=i
        //todo 웹뷰 data link 받아서 띄워주기

    }


}