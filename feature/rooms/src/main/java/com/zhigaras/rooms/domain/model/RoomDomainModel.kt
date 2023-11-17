package com.zhigaras.rooms.domain.model

import com.zhigaras.cloudservice.model.rooms.RoomDto

class RoomDomainModel(dto: RoomDto) {
    val id: Int = dto.id
    val imageUrls: List<String> = dto.imageUrls
    val name: String = dto.name
    val peculiarities: List<String> = dto.peculiarities
    val price: Int = dto.price
    val pricePer: String = dto.pricePer
}