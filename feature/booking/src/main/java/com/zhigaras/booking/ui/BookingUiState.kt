package com.zhigaras.booking.ui

import android.view.View
import com.zhigaras.booking.databinding.FragmentBookingBinding
import com.zhigaras.booking.ui.model.BookingInfoUiModel
import com.zhigaras.booking.ui.model.HotelInfoUiModel
import com.zhigaras.booking.ui.model.TourPriceUiModel
import com.zhigaras.core.UiState

interface BookingUiState : UiState<FragmentBookingBinding> {
    
    class Initial : BookingUiState {
        override fun update(binding: FragmentBookingBinding) = Unit
    }
    
    class Loading : BookingUiState {
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
            connectionError.root.visibility = View.GONE
            payload.visibility = View.GONE
        }
    }
    
    class Success(
        private val hotelInfo: HotelInfoUiModel,
        private val bookingInfo: BookingInfoUiModel,
        private val tourPrice: TourPriceUiModel
    ) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            hotelInfo.bind(bookingHotelInfoLayout)
            bookingInfo.bind(bookingInfoLayout)
            tourPrice.bind(tourPriceLayout)
            tourPrice.bindPayButton(bottomButton.button)
            progressBar.root.visibility = View.GONE
            connectionError.root.visibility = View.GONE
            payload.visibility = View.VISIBLE
        }
    }
    
    class Error(private val message: String) : BookingUiState {
        
        override fun update(binding: FragmentBookingBinding) = with(binding) {
            connectionError.errorTextView.text = message
            progressBar.root.visibility = View.GONE
            connectionError.root.visibility = View.VISIBLE
            payload.visibility = View.GONE
        }
    }
}