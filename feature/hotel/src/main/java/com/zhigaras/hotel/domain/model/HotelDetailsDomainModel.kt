package com.zhigaras.hotel.domain.model

import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.hotel.ui.model.HotelDetailsUiModel
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class HotelDetailsDomainModel(dto: HotelDetailsDto) {
    private val address: String = dto.address
    private val id: Int = dto.id
    private val imageUrls: List<String> = dto.imageUrls
    private val minimalPrice: Int = dto.minimalPrice
    private val name: String = dto.name
    private val priceUnit: String = dto.priceForIt
    private val rating: Int = dto.rating
    private val ratingName: String = dto.ratingName
    private val description: String = dto.aboutTheHotel.description
    private val peculiarities: List<String> = dto.aboutTheHotel.peculiarities
    
    fun toUiModel() = HotelDetailsUiModel(
        address = address,
        id = id,
        imageUrls = imageUrls,
        minimalPrice = minimalPrice.formatPrice(),
        name = name,
        priceUnit = priceUnit,
        rating = "$rating $ratingName",
        description = description,
        peculiarities = peculiarities
    )
    
    private fun Int.formatPrice(): String {
        val formatSymbols = DecimalFormatSymbols()
        formatSymbols.groupingSeparator = ' '
        return DecimalFormat("###,###", formatSymbols).format(this)
    }
}