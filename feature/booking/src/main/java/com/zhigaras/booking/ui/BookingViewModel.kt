package com.zhigaras.booking.ui

import com.zhigaras.booking.domain.BookingFlowWrapper
import com.zhigaras.booking.domain.BookingInteractor
import com.zhigaras.booking.ui.model.TouristInfoUiModel
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers
import com.zhigaras.core.Navigation
import com.zhigaras.ordered.ui.OrderedFragment

class BookingViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: BookingFlowWrapper.Mutable,
    private val interactor: BookingInteractor,
    private val navigation: Navigation
) : BaseViewModel<BookingUiState>(dispatchers) {
    
    init {
        fetchBookingInfo()
    }
    
    fun fetchBookingInfo() {
        flowWrapper.post(BookingUiState.Loading())
        scopeLaunch(
            onBackground = { interactor.fetchBookingInfo() },
            onUi = { it.handle(flowWrapper) }
        )
    }
    
    fun goToOrdered() = navigation.goAndAddToBackStack(OrderedFragment::class.java)
    
    fun addNewTourist() {
        flowWrapper.update {
            it.updateData { list ->
                val lastTourist = list.last { it is TouristInfoUiModel } as TouristInfoUiModel
                val lastTouristIndex = list.indexOf(lastTourist)
                list.toMutableList().apply {
                    add(lastTouristIndex + 1, TouristInfoUiModel(lastTourist.nextId()))
                }
            }
        }
    }
}