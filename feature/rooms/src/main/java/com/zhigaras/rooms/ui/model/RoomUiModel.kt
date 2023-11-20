package com.zhigaras.rooms.ui.model

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.rooms.databinding.RoomItemLayoutBinding

class RoomUiModel(
    private val id: Int,
    private val imageUrls: List<String>,
    private val name: String,
    private val peculiarities: List<String>,
    private val price: String,
    private val priceUnit: String,
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is RoomUiModel) return false
        return id == other.id
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is RoomUiModel) return false
        return id == other.id &&
                imageUrls == other.imageUrls &&
                name == other.name &&
                peculiarities == other.peculiarities &&
                price == other.price &&
                priceUnit == other.priceUnit
    }
    
    fun bind(binding: RoomItemLayoutBinding) = with(binding) {
        imageCarousel.root.setImages(imageUrls)
        hotelName.text = name
        peculiaritiesChipGroup.setPeculiarities(peculiarities)
        priceView.root.setPrice(price, priceUnit, false)
    }
}