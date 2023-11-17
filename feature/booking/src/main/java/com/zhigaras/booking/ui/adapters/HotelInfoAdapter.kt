package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.BookingHotelInfoBinding
import com.zhigaras.booking.ui.model.HotelInfoUiModel

class HotelInfoAdapter : DelegateAdapter<HotelInfoUiModel, HotelInfoAdapter.HotelInfoViewHolder>() {
    
    inner class HotelInfoViewHolder(private val binding: BookingHotelInfoBinding) :
        DelegateViewHolder<HotelInfoUiModel>(binding) {
        
        override fun bind(item: HotelInfoUiModel) {
            item.bind(binding)
        }
    }
    
    override fun viewType() = HotelInfoUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = HotelInfoViewHolder(
        BookingHotelInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}