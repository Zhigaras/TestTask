package com.zhigaras.hotel.domain.model

import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto

class HotelDetailsDomainModel(dto: HotelDetailsDto) {
    val address = dto.address
    val id = dto.id
    val imageUrls = dto.imageUrls
    val minimalPrice = dto.minimalPrice
    val name = dto.name
    val priceUnit = dto.priceForIt
    val rating = dto.rating
    val ratingName = dto.ratingName
    val description = dto.aboutTheHotel.description
    val peculiarities = dto.aboutTheHotel.peculiarities
}