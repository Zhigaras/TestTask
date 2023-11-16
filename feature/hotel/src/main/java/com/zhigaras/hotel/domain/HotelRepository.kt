package com.zhigaras.hotel.domain

import com.zhigaras.hotel.domain.model.HotelDetailsDomainModel

interface HotelRepository {
    
    suspend fun fetchHotelInfo(): HotelDetailsDomainModel
}