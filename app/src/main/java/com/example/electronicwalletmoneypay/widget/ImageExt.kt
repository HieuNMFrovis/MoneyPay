package com.example.electronicwalletmoneypay.widget

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

@SuppressLint("UseCompatLoadingForDrawables")
fun AppCompatImageView.circle(imageId: Int): RequestBuilder<Drawable> {
    return Glide.with(this)
        .load(context.getDrawable(imageId))
        .circleCrop()
}