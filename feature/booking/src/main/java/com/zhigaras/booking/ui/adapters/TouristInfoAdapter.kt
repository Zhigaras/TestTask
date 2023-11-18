package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.TouristInfoBinding
import com.zhigaras.booking.ui.model.TouristInfo

class TouristInfoAdapter :
    DelegateAdapter<TouristInfo, TouristInfoAdapter.TouristInfoViewHolder>() {
    
    inner class TouristInfoViewHolder(private val binding: TouristInfoBinding) :
        DelegateViewHolder<TouristInfo>(binding) {
        override fun bind(item: TouristInfo) {
            binding.root
        }
    }
    
    override fun viewType() = TouristInfo::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = TouristInfoViewHolder(
        TouristInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}