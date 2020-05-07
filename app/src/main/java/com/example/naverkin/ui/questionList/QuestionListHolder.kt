package com.example.naverkin.ui.questionList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naverkin.R
import com.example.naverkin.data.RvQuestionListResponse

class QuestionListHolder(private  val view: View):RecyclerView.ViewHolder(view){
    val txtTitle: TextView=view.findViewById(R.id.txt_question_title)
    val btnLink:TextView=view.findViewById(R.id.btn_question_link)
    val txtDesc:TextView=view.findViewById(R.id.txt_question_des)

    fun bind(data: RvQuestionListResponse){
        txtTitle.text=data.title
        txtDesc.text=data.descripption
        btnLink.text=data.link
    }

}