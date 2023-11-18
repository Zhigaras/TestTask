package com.zhigaras.ordered.domain

import com.zhigaras.core.FlowWrapper
import com.zhigaras.ordered.ui.OrderedUiState

interface OrderedFlowWrapper {
    
    interface Post : FlowWrapper.Post<OrderedUiState>
    interface Collect : FlowWrapper.Collect<OrderedUiState>
    interface Mutable : FlowWrapper.Mutable<OrderedUiState>, Post, Collect
    class Base : FlowWrapper.Base<OrderedUiState>(OrderedUiState.Initial()), Mutable
}