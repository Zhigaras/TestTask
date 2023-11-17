package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class NavBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    
    fun setHeader(header: String) {
        findViewById<TextView>(R.id.nav_bar_title).text = header
    }
    
    fun setBackClickListener(listener: OnClickListener) {
        findViewById<ImageView>(R.id.back_button).setOnClickListener(listener)
    }
}