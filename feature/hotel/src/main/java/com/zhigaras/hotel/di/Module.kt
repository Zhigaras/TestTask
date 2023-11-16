package com.zhigaras.hotel.di

import com.zhigaras.hotel.data.HotelRepositoryImpl
import com.zhigaras.hotel.domain.HotelInteractor
import com.zhigaras.hotel.domain.HotelRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.hotel.ui.HotelViewModel
import org.koin.dsl.bind

fun hotelModule() = module {
    
    viewModelOf(::HotelViewModel)
    
    factory { HotelInteractor.Base(get()) } bind HotelInteractor::class
    
    factory { HotelRepositoryImpl(get()) } bind HotelRepository::class
}