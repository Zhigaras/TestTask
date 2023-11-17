package com.zhigaras.rooms.ui

import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.core.UiState
import com.zhigaras.rooms.databinding.FragmentRoomsBinding
import com.zhigaras.rooms.ui.model.RoomUiModel

interface RoomsUiState : UiState<FragmentRoomsBinding> {
    
    class Initial : RoomsUiState {
        override fun update(binding: FragmentRoomsBinding) = Unit
    }
    
    class Loading : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) {
        
        }
    }
    
    class Success(private val rooms: List<RoomUiModel>) : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) {
            (binding.roomsRecyclerView.adapter as CompositeAdapter).submitList(rooms)
        }
    }
    
    class Error(private val message: String) : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) {
        
        }
    }
}