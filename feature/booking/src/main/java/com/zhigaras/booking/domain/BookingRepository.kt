package com.zhigaras.booking.domain

import com.zhigaras.booking.domain.model.BookingDomainModel

interface BookingRepository {
    
    suspend fun fetchBookingInfo(): BookingDomainModel
}