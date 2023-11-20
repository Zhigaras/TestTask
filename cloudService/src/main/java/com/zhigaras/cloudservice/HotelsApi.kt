package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.booking.BookingDto
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.cloudservice.model.rooms.RoomsInfoDto
import retrofit2.Response
import retrofit2.http.GET

internal interface HotelsApi {
    
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo(): Response<HotelDetailsDto>
    
    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoomsInfo(): Response<RoomsInfoDto>
    
    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBookingInfo(): Response<BookingDto>
    
    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}