package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TableLayout
import com.zhigaras.booking.databinding.TourPriceItemBinding

class TourPriceTable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : TableLayout(context, attrs) {
    
    init {
        for (i in 1..4) {
            val binding = TourPriceItemBinding.inflate(LayoutInflater.from(context), this, false)
            binding.priceFor.text = i.toString()
            binding.priceValue.text = "$i he,ktq"
        }
    }
}