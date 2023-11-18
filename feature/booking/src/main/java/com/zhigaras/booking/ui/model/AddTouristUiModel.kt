package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

class AddTouristUiModel : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean = true
    
    override fun areContentTheSame(other: ListItem): Boolean = true
}