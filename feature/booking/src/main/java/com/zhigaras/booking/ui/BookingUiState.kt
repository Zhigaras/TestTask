package com.zhigaras.booking.ui

import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.adapterdelegate.ListItem
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
    
    class Success(private val data: List<ListItem>) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
            (binding.bookingRecyclerView.adapter as CompositeAdapter).submitList(data)
        }
    }
    
    class Error(private val message: String) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
        
        }
    }
}