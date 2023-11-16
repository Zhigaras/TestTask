package com.zhigaras.hotel.domain

import com.zhigaras.hotel.domain.model.HotelDetailsDomainModel

interface FetchResult {
    
    fun handle(flowWrapper: HotelFlowWrapper.Post)
    
    class Success(private val data: HotelDetailsDomainModel) : FetchResult {
        override fun handle(flowWrapper: HotelFlowWrapper.Post) {
            flowWrapper.post(HotelUiState.Success(data.toUiModel()))
        }
    }
    
    class Error(private val message: String) : FetchResult {
        override fun handle(flowWrapper: HotelFlowWrapper.Post) {
            flowWrapper.post(HotelUiState.Error(message))
        }
    }
}