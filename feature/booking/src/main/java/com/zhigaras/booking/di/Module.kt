package com.zhigaras.booking.di

import com.zhigaras.booking.data.BookingRepositoryImpl
import com.zhigaras.booking.domain.BookingInteractor
import com.zhigaras.booking.domain.BookingRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.booking.ui.BookingViewModel
import org.koin.dsl.bind

fun bookingModule() = module {
    
    viewModelOf(::BookingViewModel)
    
    factory { BookingInteractor.Base(get()) } bind BookingInteractor::class
    
    factory { BookingRepositoryImpl(get()) } bind BookingRepository::class
}