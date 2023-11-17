package com.zhigaras.rooms.domain

import com.zhigaras.core.FlowWrapper

interface RoomsFlowWrapper {
    
    interface Post : FlowWrapper.Post<RoomsUiState>
    interface Collect : FlowWrapper.Collect<RoomsUiState>
    interface Mutable : FlowWrapper.Mutable<RoomsUiState>, Post, Collect
    class Base : FlowWrapper.Base<RoomsUiState>(RoomsUiState.Initial()), Mutable
}