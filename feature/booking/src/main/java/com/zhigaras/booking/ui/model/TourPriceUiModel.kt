package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

data class TourPriceUiModel(
    private val tourId: Int,
    private val tourPrice: String,
    private val fuelCharge: String,
    private val serviceCharge: String,
    private val totalPrice: String
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is TourPriceUiModel) return false
        return tourId == other.tourId
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is TourPriceUiModel) return false
        return this == other
    }
}