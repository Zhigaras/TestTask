package com.zhigaras.hotel.ui.model

import com.zhigaras.hotel.databinding.AboutHotelBinding
import com.zhigaras.hotel.databinding.HotelDetailsBinding

class HotelDetailsUiModel(
    private val address: String,
    private val id: Int,
    private val imageUrls: List<String>,
    private val minimalPrice: String,
    private val name: String,
    private val priceUnit: String,
    private val rating: String,
    private val description: String,
    private val peculiarities: List<String>
) {
    
    fun bindAboutHotel(binding: AboutHotelBinding) = with(binding) {
        imageCarousel.root.setImages(imageUrls)
        priceView.root.setPrice(minimalPrice, priceUnit, true)
        hotelInfo.root.bind(name, address, rating)
    }
    
    fun bindHotelDetails(binding: HotelDetailsBinding) = with(binding) {
        descriptionTextView.text = description
        peculiaritiesChipGroup.setPeculiarities(peculiarities)
    }
}