package com.example.riding_balloon.presentation.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.riding_balloon.R

fun ImageView.load(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this)
            .load(url)
            .placeholder(R.color.grey_shade_40)
            .error(R.drawable.ic_image_not_supported)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_image_not_supported)
    }
}