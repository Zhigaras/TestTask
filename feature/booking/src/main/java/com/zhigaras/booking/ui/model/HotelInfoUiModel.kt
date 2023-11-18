package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.booking.databinding.BookingHotelInfoBinding

class HotelInfoUiModel(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val rating: String,
) : ListItem {
    
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
    
    fun bind(binding: BookingHotelInfoBinding) = with(binding) {
        hotelInfoLayout.hotelName.text = hotelName
        hotelInfoLayout.hotelAddress.text = hotelAddress
        hotelInfoLayout.ratingTextView.text = rating
    }
}