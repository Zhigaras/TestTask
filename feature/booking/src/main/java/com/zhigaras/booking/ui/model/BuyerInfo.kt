package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

class BuyerInfo(
    private val phone: String = "",
    private val email: String = ""
) : ListItem {
    
    override fun itemType() = this::class.hashCode()
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is BuyerInfo) return false
        return phone == other.phone && email == other.email
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is BuyerInfo) return false
        return phone == other.phone && email == other.email
    }
}