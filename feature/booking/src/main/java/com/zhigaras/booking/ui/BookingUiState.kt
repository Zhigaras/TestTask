package com.zhigaras.booking.ui

import android.view.View
import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.booking.ui.model.TourPriceUiModel
import com.zhigaras.core.UiState

interface BookingUiState : UiState<FragmentBookingBinding> {
    
    fun updateData(action: (List<ListItem>) -> List<ListItem>): BookingUiState
    
    class Initial : BookingUiState {
        override fun updateData(action: (List<ListItem>) -> List<ListItem>) = this
        
        override fun update(binding: FragmentBookingBinding) = Unit
    }
    
    class Loading : BookingUiState {
        override fun updateData(action: (List<ListItem>) -> List<ListItem>) = this
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
            connectionError.root.visibility = View.GONE
            payload.visibility = View.GONE
            
        }
    }
    
    class Success(private val data: List<ListItem>) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            (bookingRecyclerView.adapter as CompositeAdapter).submitList(data)
            (data.findLast { it is TourPriceUiModel } as TourPriceUiModel)
                .bindPayButton(binding.payButton)
            progressBar.root.visibility = View.GONE
            connectionError.root.visibility = View.GONE
            payload.visibility = View.VISIBLE
        }
        
        override fun updateData(action: (List<ListItem>) -> List<ListItem>): BookingUiState {
            return Success(action.invoke(data))
        }
    }
    
    class Error(private val message: String) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            connectionError.errorTextView.text = message
            progressBar.root.visibility = View.GONE
            connectionError.root.visibility = View.VISIBLE
            payload.visibility = View.GONE
        }
        
        override fun updateData(action: (List<ListItem>) -> List<ListItem>) = this
    }
}