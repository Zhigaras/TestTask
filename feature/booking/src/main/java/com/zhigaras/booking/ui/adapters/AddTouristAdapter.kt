package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.AddTouristItemBinding
import com.zhigaras.booking.ui.model.AddTouristUiModel

class AddTouristAdapter :
    DelegateAdapter<AddTouristUiModel, AddTouristAdapter.AddTouristViewHolder>() {
    
    class AddTouristViewHolder(private val binding: AddTouristItemBinding) :
        DelegateViewHolder<AddTouristUiModel>(binding) {
        
        override fun bind(item: AddTouristUiModel) {
        
        }
    }
    
    override fun viewType() = AddTouristUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = AddTouristViewHolder(
        AddTouristItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}