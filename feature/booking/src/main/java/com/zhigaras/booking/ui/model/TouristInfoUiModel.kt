package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

class TouristInfoUiModel(
    private val id: Int,
    private val isExpanded: Boolean = false,
    private val firstName: String = "",
    private val lastName: String = "",
    private val dateOfBirth: String = "",
    private val citizenship: String = "",
    private val passportNumber: String = "",
    private val passportValidityPeriod: String = ""
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return id == other.id
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return false // TODO: fix
    }
}