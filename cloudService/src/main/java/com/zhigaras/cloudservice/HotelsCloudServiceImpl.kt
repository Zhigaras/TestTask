package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.booking.BookingDto
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.cloudservice.model.rooms.RoomsInfoDto

internal class HotelsCloudServiceImpl(private val hotelsApi: HotelsApi) : HotelsCloudService {
    
    //exception handling occurs at a higher level in Interactors
    
    override suspend fun getHotelInfo(): HotelDetailsDto {
        return hotelsApi.getHotelInfo().body()!!
    }
    
    override suspend fun getRoomsInfo(): RoomsInfoDto {
        return hotelsApi.getRoomsInfo().body()!!
    }
    
    override suspend fun getBookingInfo(): BookingDto {
        return hotelsApi.getBookingInfo().body()!!
    }
}