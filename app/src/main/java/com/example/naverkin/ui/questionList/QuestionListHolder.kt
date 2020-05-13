package com.example.naverkin.ui.questionList

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.naverkin.R
import com.example.naverkin.data.RvQuestionListResponseItems
import com.example.naverkin.WebActivity


class QuestionListHolder(private  val view: View,private val context: Context):RecyclerView.ViewHolder(view){


    val txtTitle: TextView=view.findViewById(R.id.txt_question_title)

    val txtDesc:TextView=view.findViewById(R.id.txt_question_des)


    fun bind(data: RvQuestionListResponseItems){
        txtTitle.text=Html.fromHtml(data.title)
        txtDesc.text=Html.fromHtml(data.description).slice(0..38)
        txtTitle.setOnClickListener {
            val intent=Intent(context, WebActivity::class.java)
            intent.putExtra("link",data.link)
            startActivity(context,intent, Bundle())
            Log.e("link",data.link)
        }
    }
}