package com.zhigaras.hotel.domain.model

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.zhigaras.cloudservice.model.hotel.HotelDetailsDto
import com.zhigaras.hotel.R
import com.zhigaras.hotel.databinding.AboutHotelBinding
import com.zhigaras.hotel.databinding.HotelDetailsBinding

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
    
    fun bindAboutHotel(binding: AboutHotelBinding) = with(binding) {
        hotelAddress.text = address
        hotelName.text = name
        priceTextView.text = minimalPrice.toString() // TODO: replace with extension
        imageCarousel.setImages(imageUrls)
        priceUnitTextView.text = priceUnit
        ratingTextView.root.setRating(rating, ratingName)
    }
    
    fun bindHotelDetails(binding: HotelDetailsBinding) = with(binding) {
        descriptionTextView.text = description
        peculiarities.forEach { peculiarity ->
            val chip = LayoutInflater.from(binding.root.context).inflate(
                R.layout.peculiarities_single_chip,
                binding.peculiaritiesChipGroup,
                false
            ) as Chip
            chip.text = peculiarity
            peculiaritiesChipGroup.addView(chip)
        }
    }
}