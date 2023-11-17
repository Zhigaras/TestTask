package com.zhigaras.hotel.ui

import android.os.Bundle
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.hotel.domain.HotelFlowWrapper
import com.zhigaras.hotel.domain.HotelInteractor
import com.zhigaras.rooms.ui.RoomsFragment

class HotelViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: HotelFlowWrapper.Mutable,
    private val interactor: HotelInteractor,
    private val navigation: Navigation
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
    
    fun navigateToRoomChoosing(args: Bundle? = null) {
        navigation.goAndAddToBackStack(RoomsFragment::class.java, args)
    }
}