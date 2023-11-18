package com.zhigaras.booking.domain

import kotlin.coroutines.cancellation.CancellationException

interface BookingInteractor {
    
    suspend fun fetchBookingInfo(): FetchResult
    
    class Base(private val repository: BookingRepository) : BookingInteractor {
        
        override suspend fun fetchBookingInfo(): FetchResult {
            return try {
                FetchResult.Success(repository.fetchBookingInfo())
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                FetchResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}