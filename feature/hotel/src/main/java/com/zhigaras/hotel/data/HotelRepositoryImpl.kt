package com.zhigaras.hotel.data

import com.zhigaras.cloudservice.HotelsCloudService
import com.zhigaras.hotel.domain.HotelRepository
import com.zhigaras.hotel.domain.model.HotelDetailsDomainModel

class HotelRepositoryImpl(private val cloudService: HotelsCloudService) : HotelRepository {
    
    override suspend fun fetchHotelInfo(): HotelDetailsDomainModel {
        return HotelDetailsDomainModel(cloudService.getHotelInfo())
    }
}