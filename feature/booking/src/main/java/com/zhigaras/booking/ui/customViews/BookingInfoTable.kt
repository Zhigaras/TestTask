package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.zhigaras.booking.R

class BookingInfoTable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val bookingInfo = resources.getStringArray(R.array.booking_info)
    
    fun setData(data: List<String>) {
        bookingInfo.zip(data).forEach {
            val row = LayoutInflater.from(context)
                .inflate(R.layout.booking_info_item, this, false)
                .apply {
                    findViewById<TextView>(R.id.info_type).text = it.first
                    findViewById<TextView>(R.id.info_value).text = it.second
                }
            addView(row)
        }
    }
}