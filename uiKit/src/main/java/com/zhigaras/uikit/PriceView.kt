package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class PriceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    
    private val priceTextView by lazy { findViewById<TextView>(R.id.price_text_view) }
    private val priceUnitTextView by lazy { findViewById<TextView>(R.id.price_unit_text_view) }
    
    fun setPrice(price: String, priceUnit: String, isStartedFrom: Boolean) {
        priceTextView.text = buildString {
            if (isStartedFrom) append(context.getString(R.string.from))
            append(' ')
            append(price)
            append(' ')
            append(context.getString(R.string.ruble_sign))
        }
        priceUnitTextView.text = priceUnit
    }
}