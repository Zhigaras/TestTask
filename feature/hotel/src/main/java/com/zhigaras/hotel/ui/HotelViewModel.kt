package com.zhigaras.hotel.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.hotel.domain.HotelFlowWrapper
import com.zhigaras.hotel.domain.HotelInteractor
import com.zhigaras.hotel.domain.HotelUiState

class HotelViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: HotelFlowWrapper.Mutable,
    private val interactor: HotelInteractor
) : BaseViewModel<HotelUiState>(dispatchers) {
    
    init {
        fetchHotelInfo()
    }
    
    fun fetchHotelInfo() {
        flowWrapper.post(HotelUiState.Loading())
        scopeLaunch(
            onBackground = { interactor.fetchHotelInfo() },
            onUi = { it.handle(flowWrapper) }
        )
    }
}