package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.R
import com.zhigaras.booking.databinding.BuyerInfoBinding
import com.zhigaras.booking.ui.model.BuyerInfoUiModel

class BuyerInfoAdapter : DelegateAdapter<BuyerInfoUiModel, BuyerInfoAdapter.BuyerInfoViewHolder>() {
    
    inner class BuyerInfoViewHolder(private val binding: BuyerInfoBinding) :
        DelegateViewHolder<BuyerInfoUiModel>(binding) {
        override fun bind(item: BuyerInfoUiModel) {
            binding.emailInput.root.setHint(R.string.email)
            binding.phoneInput.root.setHint(R.string.phone_number)
        }
    }
    
    override fun viewType() = BuyerInfoUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = BuyerInfoViewHolder(
        BuyerInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}