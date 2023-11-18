package com.zhigaras.booking.di

import com.zhigaras.booking.data.BookingRepositoryImpl
import com.zhigaras.booking.domain.BookingFlowWrapper
import com.zhigaras.booking.domain.BookingInteractor
import com.zhigaras.booking.domain.BookingRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.booking.ui.BookingViewModel
import org.koin.dsl.bind
import org.koin.dsl.binds

fun bookingModule() = module {
    
    viewModelOf(::BookingViewModel)
    
    factory { BookingInteractor.Base(get()) } bind BookingInteractor::class
    
    factory { BookingRepositoryImpl(get()) } bind BookingRepository::class
    
    factory { BookingFlowWrapper.Base() } binds arrayOf(
        BookingFlowWrapper.Collect::class,
        BookingFlowWrapper.Post::class,
        BookingFlowWrapper.Mutable::class
    )
}