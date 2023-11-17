package com.zhigaras.rooms.ui

import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.rooms.domain.RoomsFlowWrapper
import com.zhigaras.rooms.domain.RoomsInteractor

class RoomsViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: RoomsFlowWrapper.Mutable,
    private val interactor: RoomsInteractor
) : BaseViewModel<RoomsUiState>(dispatchers) {
    
    init {
        scopeLaunch(
            onBackground = { interactor.fetchRooms() },
            onUi = { it.handle(flowWrapper) }
        )
    }
}