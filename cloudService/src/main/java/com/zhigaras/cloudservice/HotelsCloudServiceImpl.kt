package com.zhigaras.cloudservice

import com.zhigaras.cloudservice.model.booking.BookingDto
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.cloudservice.model.rooms.RoomsInfoDto
import retrofit2.Response
import kotlin.coroutines.cancellation.CancellationException

internal class HotelsCloudServiceImpl(
    private val hotelsApi: HotelsApi
) : BaseRepository(), HotelsCloudService {
    
    override suspend fun getHotelInfo(): ApiResponse<HotelDetailsDto> {
        return fetch { hotelsApi.getHotelInfo() }
    }
    
    override suspend fun getRoomsInfo(): ApiResponse<RoomsInfoDto> {
        return fetch { hotelsApi.getRoomsInfo() }
    }
    
    override suspend fun getBookingInfo(): ApiResponse<BookingDto> {
        return fetch { hotelsApi.getBookingInfo() }
    }
}

abstract class BaseRepository {
    
    suspend fun <T : Any> fetch(request: suspend () -> Response<T>): ApiResponse<T> {
        return try {
            val result = request.invoke()
            ApiResponse.Success(result.body()!!)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            ApiResponse.Error(e.message ?: "")
        }
    }
}