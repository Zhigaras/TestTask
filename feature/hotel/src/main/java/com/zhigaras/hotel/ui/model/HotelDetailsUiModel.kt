package com.zhigaras.hotel.ui.model

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.zhigaras.hotel.R
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
        priceTextView.text = binding.root.context.getString(R.string.price_from, minimalPrice)
        imageCarousel.root.setImages(imageUrls)
        priceUnitTextView.text = priceUnit
        hotelInfo.root.bind(name, address, rating)
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