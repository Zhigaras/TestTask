package com.zhigaras.booking.domain

import com.zhigaras.booking.domain.model.BookingDomainModel
import com.zhigaras.booking.ui.BookingUiState

interface FetchResult {
    
    fun handle(flowWrapper: BookingFlowWrapper.Post)
    
    class Success(private val data: BookingDomainModel) : FetchResult {
        
        override fun handle(flowWrapper: BookingFlowWrapper.Post) {
            flowWrapper.post(BookingUiState.Success(data.toUiModel()))
        }
    }
    
    class Error(private val message: String) : FetchResult {
        
        override fun handle(flowWrapper: BookingFlowWrapper.Post) {
            flowWrapper.post(BookingUiState.Error(message))
        }
    }
}