package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.AddTouristItemBinding
import com.zhigaras.booking.ui.model.AddTouristUiModel

class AddTouristAdapter(
    private val onAddTouristClick: () -> Unit
) : DelegateAdapter<AddTouristUiModel, AddTouristAdapter.AddTouristViewHolder>() {
    
    inner class AddTouristViewHolder(private val binding: AddTouristItemBinding) :
        DelegateViewHolder<AddTouristUiModel>(binding) {
        
        override fun bind(item: AddTouristUiModel) {
            binding.addTouristButton.setOnClickListener { onAddTouristClick.invoke() }
        }
    }
    
    override fun viewType() = AddTouristUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = AddTouristViewHolder(
        AddTouristItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}