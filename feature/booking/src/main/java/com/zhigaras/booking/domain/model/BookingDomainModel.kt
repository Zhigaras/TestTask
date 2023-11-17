package com.zhigaras.booking.domain.model

import com.zhigaras.booking.ui.model.BookingInfoUiModel
import com.zhigaras.booking.ui.model.HotelInfoUiModel
import com.zhigaras.cloudservice.model.booking.BookingDto

class BookingDomainModel(dto: BookingDto) {
    private val arrivalCountry: String = dto.arrivalCountry
    private val departure: String = dto.departure
    private val fuelCharge: Int = dto.fuelCharge
    private val rating: Int = dto.rating
    private val hotelAddress: String = dto.hotelAddress
    private val hotelName: String = dto.hotelName
    private val id: Int = dto.id
    private val numberOfNights: Int = dto.numberOfNights
    private val nutrition: String = dto.nutrition
    private val ratingName: String = dto.ratingName
    private val room: String = dto.room
    private val serviceCharge: Int = dto.serviceCharge
    private val tourDateStart: String = dto.tourDateStart
    private val tourDateStop: String = dto.tourDateStop
    private val tourPrice: Int = dto.tourPrice
    
    fun makeHotelInfo() = HotelInfoUiModel(
        id = id,
        hotelName = hotelName,
        hotelAddress = hotelAddress,
        rating = "$rating $ratingName"
    )
    
    fun makeBookingInfo() = BookingInfoUiModel(
        id = id,
        arrivalCountry = arrivalCountry,
        departure = departure,
        hotelName = hotelName,
        numberOfNights = numberOfNights.toString(),
        nutrition = nutrition,
        room = room,
        tourDates = "$tourDateStart-$tourDateStop"
    )
    
    fun toUi() = listOf(makeHotelInfo(), makeBookingInfo())
}