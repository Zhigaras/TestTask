package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class NavBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    
    fun addBackNavigation(fragmentManager: FragmentManager) {
        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            fragmentManager.popBackStack()
        }
    }
    
    fun setHeader(header: String) {
        findViewById<TextView>(R.id.nav_bar_title).text = header
    }
}