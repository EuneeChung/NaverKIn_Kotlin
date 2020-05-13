package com.example.naverkin.data

data class QuestionListResponse(
    val lastBuildDate:String,
    val total:Int,
    val start:Int,
    val display:Int,
    val items:ArrayList<RvQuestionListResponseItems>
)
data class RvQuestionListResponseItems(
    val title:String,
    val link:String,
    val description:String
)