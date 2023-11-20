package com.zhigaras.rooms.ui

import android.os.Bundle
import com.zhigaras.booking.ui.BookingFragment
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.rooms.domain.RoomsFlowWrapper
import com.zhigaras.rooms.domain.RoomsInteractor

class RoomsViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: RoomsFlowWrapper.Mutable,
    private val interactor: RoomsInteractor,
    private val navigation: Navigation
) : BaseViewModel<RoomsUiState>(dispatchers) {
    
    init {
        fetchRooms()
    }
    
    fun fetchRooms() {
        flowWrapper.post(RoomsUiState.Loading())
        scopeLaunch(
            onBackground = { interactor.fetchRooms() },
            onUi = { it.handle(flowWrapper) }
        )
    }
    
    fun navigateToBooking(args: Bundle? = null) {
        navigation.goAndAddToBackStack(BookingFragment::class.java, args)
    }
}