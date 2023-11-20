package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem

data class TouristInfoUiModel(
    private val number: Int,
    private val isExpanded: Boolean,
    private val firstName: String = "",
    private val lastName: String = "",
    private val dateOfBirth: String = "",
    private val citizenship: String = "",
    private val passportNumber: String = "",
    private val passportValidityPeriod: String = ""
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return number == other.number
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return true // TODO: check
    }
}