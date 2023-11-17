package com.zhigaras.booking.ui

import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.core.UiState

interface BookingUiState : UiState<FragmentBookingBinding> {
    
    class Initial : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) = Unit
    }
    
    class Loading : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
        
        }
    }
    
    class Success(private val data: BookingUiModel) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
        
        }
    }
    
    class Error(private val message: String) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
        
        }
    }
}