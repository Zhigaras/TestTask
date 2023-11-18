package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

class BuyerInfoUiModel(
    private val phone: String = "",
    private val email: String = ""
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is BuyerInfoUiModel) return false
        return phone == other.phone && email == other.email
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is BuyerInfoUiModel) return false
        return phone == other.phone && email == other.email
    }
}