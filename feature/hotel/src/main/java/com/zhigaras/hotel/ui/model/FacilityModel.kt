package com.zhigaras.hotel.ui.model

import androidx.annotation.DrawableRes
import com.zhigaras.hotel.databinding.FacilitiesItemBinding

class FacilityModel(
    @DrawableRes private val icon: Int,
    private val topText: String,
    private val bottomText: String
) {
    fun bind(binding: FacilitiesItemBinding) {
        with(binding) {
            facilitiesIcon.setImageResource(icon)
            facilitiesTopTextView.text = topText
            facilitiesBottomTextView.text = bottomText
        }
    }
}