package com.zhigaras.hotel.domain

import com.zhigaras.core.UiState
import com.zhigaras.hotel.databinding.FragmentHotelBinding
import com.zhigaras.hotel.domain.model.HotelDetailsDomainModel

interface HotelUiState : UiState<FragmentHotelBinding> {
    
    class Initial : HotelUiState {
        override fun update(binding: FragmentHotelBinding) = Unit
    }
    
    class Loading : HotelUiState {
        override fun update(binding: FragmentHotelBinding) {
        
        }
    }
    
    class Success(private val data: HotelDetailsDomainModel) : HotelUiState {
        override fun update(binding: FragmentHotelBinding) {
            data.bindAboutHotel(binding.aboutHotelLayout)
            data.bindHotelDetails(binding.hotelDetailsLayout)
        }
    }
    
    class Error(private val message: String) : HotelUiState {
        override fun update(binding: FragmentHotelBinding) {
        
        }
    }
}