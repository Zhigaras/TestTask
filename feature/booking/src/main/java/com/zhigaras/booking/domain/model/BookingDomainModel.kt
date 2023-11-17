package com.zhigaras.booking.domain.model

import com.zhigaras.booking.ui.BookingUiModel
import com.zhigaras.cloudservice.model.booking.BookingDto

class BookingDomainModel(dto: BookingDto) {
    val arrivalCountry: String = dto.arrivalCountry
    val departure: String = dto.departure
    val fuelCharge: Int = dto.fuelCharge
    val rating: Int = dto.rating
    val hotelAddress: String = dto.hotelAddress
    val hotelName: String = dto.hotelName
    val id: Int = dto.id
    val numberOfNights: Int = dto.numberOfNights
    val nutrition: String = dto.nutrition
    val ratingName: String = dto.ratingName
    val room: String = dto.room
    val serviceCharge: Int = dto.serviceCharge
    val tourDateStart: String = dto.tourDateStart
    val tourDateStop: String = dto.tourDateStop
    val tourPrice: Int = dto.tourPrice
    
    fun toUiModel() = BookingUiModel()
}