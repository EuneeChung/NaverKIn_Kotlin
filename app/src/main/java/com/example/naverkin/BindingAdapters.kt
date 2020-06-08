package com.example.naverkin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter


@BindingAdapter("app:onClickLink")
fun onClickLink(view: View, link: String) {
    view.setOnClickListener {
        val intent = Intent(view.context, WebActivity::class.java)
        intent.putExtra("link", link)
        startActivity(view.context, intent, Bundle())
    }
}

