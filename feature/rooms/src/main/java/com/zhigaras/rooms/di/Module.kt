package com.zhigaras.rooms.di

import com.zhigaras.rooms.data.RoomsRepositoryImpl
import com.zhigaras.rooms.domain.RoomsFlowWrapper
import com.zhigaras.rooms.domain.RoomsInteractor
import com.zhigaras.rooms.domain.RoomsRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.rooms.ui.RoomsViewModel
import org.koin.dsl.bind
import org.koin.dsl.binds

fun roomsModule() = module {
    
    viewModelOf(::RoomsViewModel)
    
    factory { RoomsInteractor.Base(get()) } bind RoomsInteractor::class
    
    factory { RoomsFlowWrapper.Base() } binds arrayOf(
        RoomsFlowWrapper.Collect::class,
        RoomsFlowWrapper.Post::class,
        RoomsFlowWrapper.Mutable::class
    )
    
    factory { RoomsRepositoryImpl(get()) } bind RoomsRepository::class
}