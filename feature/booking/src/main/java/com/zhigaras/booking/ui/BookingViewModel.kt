package com.zhigaras.booking.ui

import com.zhigaras.booking.domain.BookingFlowWrapper
import com.zhigaras.booking.domain.BookingInteractor
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers

class BookingViewModel(
    dispatchers: Dispatchers,
    override val flowWrapper: BookingFlowWrapper.Mutable,
    private val interactor: BookingInteractor
) : BaseViewModel<BookingUiState>(dispatchers) {
}