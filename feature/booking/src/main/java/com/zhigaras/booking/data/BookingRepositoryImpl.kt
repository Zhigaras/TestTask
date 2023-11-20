package com.zhigaras.booking.data

import com.zhigaras.booking.domain.BookingRepository
import com.zhigaras.booking.domain.model.BookingDomainModel
import com.zhigaras.cloudservice.HotelsCloudService

class BookingRepositoryImpl(private val cloudService: HotelsCloudService) : BookingRepository {
    
    override suspend fun fetchBookingInfo(): BookingDomainModel {
        return BookingDomainModel(cloudService.getBookingInfo())
    }
}