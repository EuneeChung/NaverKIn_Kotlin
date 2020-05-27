package com.example.naverkin.data

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.naverkin.WebActivity

data class QuestionListResponse(
    val lastBuildDate:String,
    val total:Int,
    val start:Int,
    val display:Int,
    val items:ArrayList<RvQuestionListResponseItems>
)

 class RvQuestionListResponseItems{
    val title: String =""
    val link: String=""
    val description: String=""

     fun onClickLink(view: View) {

             val intent = Intent(view.context, WebActivity::class.java)
             intent.putExtra("link", link)
             startActivity(view.context, intent, Bundle())
         }

}