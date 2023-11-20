package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.TouristInfoBinding
import com.zhigaras.booking.ui.model.TouristInfoUiModel

class TouristInfoAdapter :
    DelegateAdapter<TouristInfoUiModel, TouristInfoAdapter.TouristInfoViewHolder>() {
    
    inner class TouristInfoViewHolder(private val binding: TouristInfoBinding) :
        DelegateViewHolder<TouristInfoUiModel>(binding) {
        override fun bind(item: TouristInfoUiModel) {
            item.bind(binding)
        }
    }
    
    override fun viewType() = TouristInfoUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = TouristInfoViewHolder(
        TouristInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}