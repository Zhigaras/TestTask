package com.zhigaras.booking.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.zhigaras.booking.R

class TouristInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val hints = resources.getStringArray(R.array.tourist_info)
    
    init {
        hints.forEach {
            val inputView = LayoutInflater.from(context).inflate(R.layout.input_layout, this, false)
            (inputView as BuyerInfoInput).hint = it
            addView(inputView)
        }
    }
}