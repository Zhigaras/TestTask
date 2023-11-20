package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import com.zhigaras.booking.R

class BookingLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractLinearLayout(context, attrs, defStyleAttr) {
    
    private val firstTourist by lazy { findViewById<TouristInfoLayout>(R.id.tourist_info_layout) }
    private val addTouristView by lazy { findViewById<LinearLayout>(R.id.add_tourist_layout) }
    private val addTouristButton by lazy { findViewById<ImageView>(R.id.add_tourist_button) }
    private val tourists by lazy { mutableListOf<TouristInfoLayout>(firstTourist) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        firstTourist.bind(true, 0)
        addTouristButton.setOnClickListener {
            addTourist()
        }
    }
    
    private fun addTourist() {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.tourist_info, this, false) as TouristInfoLayout
        tourists.add(view)
        view.bind(false, tourists.lastIndex)
        addView(view, indexOfChild(addTouristView))
    }
}