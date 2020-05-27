package com.example.naverkin.ui.questionList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.naverkin.R
import com.example.naverkin.data.RvQuestionListResponseItems
import com.example.naverkin.databinding.RvQuestionListBinding

class QuestionListAdapter(private val context: Context)  : RecyclerView.Adapter<QuestionListHolder>() {

     var data = arrayListOf<RvQuestionListResponseItems>()
    private lateinit var onclick: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionListHolder {
      //  val view=LayoutInflater.from(context).inflate(R.layout.rv_question_list,parent,false)
      //  view.setOnClickListener(onclick)
      //  return QuestionListHolder(view, context)
        return QuestionListHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.rv_question_list,parent,false),context)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: QuestionListHolder, position: Int) {
       holder.bind(data[position])
    }

    fun getLink(position: Int):String=data[position].link



}