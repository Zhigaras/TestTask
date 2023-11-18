package com.zhigaras.ordered.ui

import com.zhigaras.core.UiState
import com.zhigaras.ordered.databinding.FragmentOrderedBinding

interface OrderedUiState : UiState<FragmentOrderedBinding> {
    
    class Initial : OrderedUiState {
        override fun update(binding: FragmentOrderedBinding) = Unit
    }
}