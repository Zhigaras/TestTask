package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.TourPriceLayoutBinding
import com.zhigaras.booking.ui.model.TourPriceUiModel

class TourPriceAdapter : DelegateAdapter<TourPriceUiModel, TourPriceAdapter.TourPriceViewHolder>() {
    
    class TourPriceViewHolder(private val binding: TourPriceLayoutBinding) :
        DelegateViewHolder<TourPriceUiModel>(binding) {
        
        override fun bind(item: TourPriceUiModel) {
            item.bind(binding)
        }
    }
    
    override fun viewType() = TourPriceUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup) = TourPriceViewHolder(
        TourPriceLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
}