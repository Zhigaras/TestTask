package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.R
import com.zhigaras.booking.databinding.BuyerInfoBinding
import com.zhigaras.booking.ui.model.BuyerInfo

class BuyerInfoAdapter : DelegateAdapter<BuyerInfo, BuyerInfoAdapter.BuyerInfoViewHolder>() {
    
    inner class BuyerInfoViewHolder(private val binding: BuyerInfoBinding) :
        DelegateViewHolder<BuyerInfo>(binding) {
        override fun bind(item: BuyerInfo) {
            binding.emailInput.root.setHint(R.string.email)
            binding.phoneInput.root.setHint(R.string.phone_number)
        }
    }
    
    override fun viewType() = BuyerInfo::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = BuyerInfoViewHolder(
        BuyerInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}