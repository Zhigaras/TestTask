package com.zhigaras.ordered.di

import com.zhigaras.ordered.domain.OrderedFlowWrapper
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.ordered.ui.OrderedViewModel
import org.koin.dsl.binds

fun orderedModule() = module {
    
    viewModelOf(::OrderedViewModel)
    
    factory { OrderedFlowWrapper.Base() } binds arrayOf(
        OrderedFlowWrapper.Mutable::class,
        OrderedFlowWrapper.Post::class,
        OrderedFlowWrapper.Collect::class
    )
}