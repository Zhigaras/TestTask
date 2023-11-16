package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.booking.BookingDto
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.cloudservice.model.rooms.RoomsInfoDto

interface HotelsCloudService {
    
    suspend fun getHotelInfo(): HotelDetailsDto
    
    suspend fun getRoomsInfo(): RoomsInfoDto
    
    suspend fun getBookingInfo(): BookingDto
    
}