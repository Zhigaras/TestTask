package com.zhigaras.booking.ui

import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.booking.ui.model.TourPriceUiModel
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
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            (bookingRecyclerView.adapter as CompositeAdapter).submitList(data)
            (data.findLast { it is TourPriceUiModel } as TourPriceUiModel)
                .bindPayButton(binding.payButton)
        }
    }
    
    class Error(private val message: String) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) {
        
        }
    }
}