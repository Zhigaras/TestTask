package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

class BookingInfoUiModel(
    val id: Int,
    val arrivalCountry: String,
    val departure: String,
    val hotelName: String,
    val numberOfNights: Int,
    val nutrition: String,
    val room: String,
    val tourDates: String,
) : ListItem {
    override fun itemType() = this::class.hashCode() // TODO: move to parent
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is BookingInfoUiModel) return false
        return id == other.id
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is BookingInfoUiModel) return false
        return arrivalCountry == other.arrivalCountry &&
                departure == other.departure &&
                hotelName == other.hotelName &&
                numberOfNights == other.numberOfNights &&
                nutrition == other.nutrition &&
                room == other.room &&
                tourDates == other.tourDates
    }
}