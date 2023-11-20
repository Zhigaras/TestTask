package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class HotelInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val nameTextView by lazy { findViewById<TextView>(R.id.hotel_name) }
    private val addressTextView by lazy { findViewById<TextView>(R.id.hotel_address) }
    private val ratingTextView by lazy { findViewById<TextView>(R.id.rating_text_view) }
    
    fun bind(name: String, address: String, rating: String) {
        nameTextView.text = name
        addressTextView.text = address
        ratingTextView.text = rating
    }
}