package com.zhigaras.hotel.domain

import kotlin.coroutines.cancellation.CancellationException

interface HotelInteractor {
    
    suspend fun fetchHotelInfo(): FetchResult
    
    class Base(private val repository: HotelRepository) : HotelInteractor {
        
        override suspend fun fetchHotelInfo(): FetchResult {
            return try {
                FetchResult.Success(repository.fetchHotelInfo())
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                FetchResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}