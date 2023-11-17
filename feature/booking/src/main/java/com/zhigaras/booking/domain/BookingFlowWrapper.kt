package com.zhigaras.booking.domain

import com.zhigaras.booking.ui.BookingUiState
import com.zhigaras.core.FlowWrapper

interface BookingFlowWrapper {
    
    interface Post : FlowWrapper.Post<BookingUiState>
    interface Collect : FlowWrapper.Collect<BookingUiState>
    interface Mutable : FlowWrapper.Mutable<BookingUiState>, Post, Collect
    class Base : FlowWrapper.Base<BookingUiState>(BookingUiState.Initial()), Mutable
}