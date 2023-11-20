package com.zhigaras.rooms.domain

import kotlin.coroutines.cancellation.CancellationException

interface RoomsInteractor {
    
    suspend fun fetchRooms(): FetchResult
    
    class Base(private val repository: RoomsRepository) : RoomsInteractor {
        
        override suspend fun fetchRooms(): FetchResult {
            return try {
                FetchResult.Success(repository.fetchRooms())
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                FetchResult.Error(e.message ?: "Something went wrong")
            }
        }
    }
}