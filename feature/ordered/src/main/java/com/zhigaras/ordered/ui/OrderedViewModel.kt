package com.zhigaras.ordered.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.ordered.domain.OrderedFlowWrapper

class OrderedViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: OrderedFlowWrapper.Mutable,
    private val navigation: Navigation
) : BaseViewModel<OrderedUiState>(dispatchers) {
    

}