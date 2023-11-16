package com.zhigaras.uikit

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glideLoad(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)