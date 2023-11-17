package com.zhigaras.rooms.ui

import android.view.View
import com.zhigaras.adapterdelegate.CompositeAdapter
import com.zhigaras.core.UiState
import com.zhigaras.rooms.databinding.FragmentRoomsBinding
import com.zhigaras.rooms.ui.model.RoomUiModel

interface RoomsUiState : UiState<FragmentRoomsBinding> {
    
    class Initial : RoomsUiState {
        override fun update(binding: FragmentRoomsBinding) = Unit
    }
    
    class Loading : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) = with(binding) {
            progressBar.root.visibility = View.VISIBLE
            payload.visibility = View.GONE
            connectionError.root.visibility = View.GONE
        }
    }
    
    class Success(private val rooms: List<RoomUiModel>) : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) = with(binding) {
            (roomsRecyclerView.adapter as CompositeAdapter).submitList(rooms)
            payload.visibility = View.VISIBLE
            progressBar.root.visibility = View.GONE
            connectionError.root.visibility = View.GONE
        }
    }
    
    class Error(private val message: String) : RoomsUiState {
        
        override fun update(binding: FragmentRoomsBinding) = with(binding) {
            connectionError.errorTextView.text = message
            connectionError.root.visibility = View.VISIBLE
            payload.visibility = View.GONE
            progressBar.root.visibility = View.GONE
        }
    }
}