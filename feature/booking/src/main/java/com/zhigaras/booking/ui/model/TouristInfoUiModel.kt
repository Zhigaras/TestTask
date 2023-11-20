package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.booking.databinding.TouristInfoBinding

data class TouristInfoUiModel(
    val number: Int,
    val isExpanded: Boolean = false,
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
    
    fun nextNumber() = number + 1
    
    fun bind(binding: TouristInfoBinding) = with(binding) {
        root.bind(isExpanded, number,)
    }
}