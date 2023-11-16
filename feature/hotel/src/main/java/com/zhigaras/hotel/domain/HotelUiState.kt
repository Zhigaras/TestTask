package com.zhigaras.hotel.domain

import android.view.View
import com.zhigaras.core.UiState
import com.zhigaras.hotel.databinding.FragmentHotelBinding
import com.zhigaras.hotel.ui.model.HotelDetailsUiModel

interface HotelUiState : UiState<FragmentHotelBinding> {
    
    class Initial : HotelUiState {
        override fun update(binding: FragmentHotelBinding) = Unit
    }
    
    class Loading : HotelUiState {
        override fun update(binding: FragmentHotelBinding) = with(binding) {
            payload.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }
    
    class Success(private val data: HotelDetailsUiModel) : HotelUiState {
        override fun update(binding: FragmentHotelBinding) = with(binding) {
            data.bindAboutHotel(aboutHotelLayout)
            data.bindHotelDetails(hotelDetailsLayout)
            payload.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }
    
    class Error(private val message: String) : HotelUiState {
        
        override fun update(binding: FragmentHotelBinding) {
        
        }
    }
}