package com.zhigaras.hotel.domain

import com.zhigaras.core.FlowWrapper
import com.zhigaras.hotel.ui.HotelUiState

interface HotelFlowWrapper {
    
    interface Post : FlowWrapper.Post<HotelUiState>
    interface Collect : FlowWrapper.Collect<HotelUiState>
    interface Mutable : FlowWrapper.Mutable<HotelUiState>, Post, Collect
    class Base : FlowWrapper.Base<HotelUiState>(HotelUiState.Initial()), Mutable
}