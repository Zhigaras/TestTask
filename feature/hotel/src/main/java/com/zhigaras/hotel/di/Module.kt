package com.zhigaras.hotel.di

import com.zhigaras.cloudservice.di.cloudServiceModule
import com.zhigaras.hotel.data.HotelRepositoryImpl
import com.zhigaras.hotel.domain.HotelFlowWrapper
import com.zhigaras.hotel.domain.HotelInteractor
import com.zhigaras.hotel.domain.HotelRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.hotel.ui.HotelViewModel
import com.zhigaras.rooms.di.roomsModule
import org.koin.dsl.bind
import org.koin.dsl.binds

fun hotelModule() = listOf(cloudServiceModule()) + roomsModule() + module {
    
    viewModelOf(::HotelViewModel)
    
    factory { HotelInteractor.Base(get()) } bind HotelInteractor::class
    
    factory { HotelRepositoryImpl(get()) } bind HotelRepository::class
    
    factory { HotelFlowWrapper.Base() } binds arrayOf(
        HotelFlowWrapper.Post::class,
        HotelFlowWrapper.Collect::class,
        HotelFlowWrapper.Mutable::class
    )
}