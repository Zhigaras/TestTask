package com.zhigaras.booking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zhigaras.adapterdelegate.DelegateAdapter
import com.zhigaras.adapterdelegate.DelegateViewHolder
import com.zhigaras.booking.databinding.BookingInfoBinding
import com.zhigaras.booking.ui.model.BookingInfoUiModel

class BookingInfoAdapter :
    DelegateAdapter<BookingInfoUiModel, BookingInfoAdapter.BookingInfoViewHolder>() {
    
    inner class BookingInfoViewHolder(
        private val binding: BookingInfoBinding
    ) : DelegateViewHolder<BookingInfoUiModel>(binding) {
        override fun bind(item: BookingInfoUiModel) {
            item.bind(binding)
        }
    }
    
    override fun viewType() = BookingInfoUiModel::class.hashCode()
    
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        BookingInfoViewHolder(
            BookingInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
}