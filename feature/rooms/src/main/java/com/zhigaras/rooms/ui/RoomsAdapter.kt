package com.zhigaras.rooms.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.rooms.databinding.RoomItemLayoutBinding
import com.zhigaras.rooms.ui.model.RoomUiModel

class RoomsAdapter(
    private val onClick: () -> Unit
) : DelegateAdapter<RoomUiModel, RoomsAdapter.RoomsViewHolder>() {
    
    inner class RoomsViewHolder(private val binding: RoomItemLayoutBinding) :
        DelegateViewHolder<RoomUiModel>(binding) {
        override fun bind(item: RoomUiModel) {
            item.bind(binding)
            binding.toBookingButton.setOnClickListener { onClick.invoke() }
        }
    }
    
    override fun viewType() = RoomUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = RoomsViewHolder(
        RoomItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}