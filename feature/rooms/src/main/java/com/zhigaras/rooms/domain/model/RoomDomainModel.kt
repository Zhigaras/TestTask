package com.zhigaras.rooms.domain.model

import com.zhigaras.cloudservice.model.rooms.RoomDto
import com.zhigaras.rooms.ui.model.RoomUiModel

class RoomDomainModel(dto: RoomDto) {
    private val id: Int = dto.id
    private val imageUrls: List<String> = dto.imageUrls
    private val name: String = dto.name
    private val peculiarities: List<String> = dto.peculiarities
    private val price: Int = dto.price
    private val pricePer: String = dto.pricePer
    
    fun toUiModel() = RoomUiModel(
        id = id,
        imageUrls = imageUrls,
        name = name,
        peculiarities = peculiarities,
        price = price,
        priceUnit = pricePer
    )
}