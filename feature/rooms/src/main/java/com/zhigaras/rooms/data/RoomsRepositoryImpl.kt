package com.zhigaras.rooms.data

import com.zhigaras.cloudservice.HotelsCloudService
import com.zhigaras.rooms.domain.RoomsRepository
import com.zhigaras.rooms.domain.model.RoomDomainModel

class RoomsRepositoryImpl(private val cloudService: HotelsCloudService) : RoomsRepository {
    
    override suspend fun fetchRooms(): List<RoomDomainModel> {
        return cloudService.getRoomsInfo().rooms.map { RoomDomainModel(it) }
    }
}