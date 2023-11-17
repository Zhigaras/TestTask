package com.zhigaras.rooms.domain

import com.zhigaras.rooms.domain.model.RoomDomainModel

interface RoomsRepository {
    
    suspend fun fetchRooms(): List<RoomDomainModel>
}