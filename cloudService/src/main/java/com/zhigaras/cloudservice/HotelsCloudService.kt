package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.booking.BookingDto
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.cloudservice.model.rooms.RoomsInfoDto

interface HotelsCloudService {
    
    suspend fun getHotelInfo(): ApiResponse<HotelDetailsDto>
    
    suspend fun getRoomsInfo(): ApiResponse<RoomsInfoDto>
    
    suspend fun getBookingInfo(): ApiResponse<BookingDto>
    
}