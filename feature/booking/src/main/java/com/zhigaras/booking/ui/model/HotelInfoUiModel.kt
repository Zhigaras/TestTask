package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.uikit.databinding.HotelInfoLayoutBinding

class HotelInfoUiModel(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val rating: String,
) : ListItem {
    
    override fun itemType() = this::class.hashCode()
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is HotelInfoUiModel) return false
        return id == other.id
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is HotelInfoUiModel) return false
        return hotelName == other.hotelName &&
                hotelAddress == other.hotelAddress &&
                rating == other.rating
    }
    
    fun bind(binding: HotelInfoLayoutBinding) {
        binding.hotelName.text = hotelName
        binding.hotelAddress.text = hotelAddress
        binding.ratingTextView.text = rating
    }
}