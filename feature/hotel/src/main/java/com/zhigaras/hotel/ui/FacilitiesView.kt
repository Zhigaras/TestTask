package com.zhigaras.hotel.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.zhigaras.hotel.R
import com.zhigaras.hotel.databinding.FacilitiesItemBinding
import com.zhigaras.hotel.ui.model.FacilityModel

class FacilitiesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val iconList =
        listOf(R.drawable.emoji_happy, R.drawable.tick_square, R.drawable.close_square)
    private val topTextList = resources.getStringArray(R.array.facilities)
    private val contentList = iconList.zip(topTextList)
        .map { FacilityModel(it.first, it.second, resources.getString(R.string.all_the_necessary)) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        contentList.forEach {
            val binding = FacilitiesItemBinding.inflate(LayoutInflater.from(context))
            it.bind(binding)
            addView(binding.root)
        }
    }
}