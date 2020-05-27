package com.example.naverkin.data

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.naverkin.WebActivity

data class QuestionListResponse(
    val lastBuildDate:String,
    val total:Int,
    val start:Int,
    val display:Int,
    val items:ArrayList<RvQuestionListResponseItems>
)

data class RvQuestionListResponseItems(
    val title: String ="",
    val link: String="" ,
    val description: String=""
)