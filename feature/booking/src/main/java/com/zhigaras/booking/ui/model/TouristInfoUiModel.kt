package com.zhigaras.booking.ui.model

import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.adapterdelegate.Payload
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
        return isExpanded == other.isExpanded
    }
    
    override fun payload(other: ListItem): Payload<*> {
        if (other !is TouristInfoUiModel) return Payload.None()
        if (isExpanded != other.isExpanded) return ExpandingChanged(other.isExpanded)
        return Payload.None()
    }
    
    fun nextId() = number + 1
    
    fun bind(binding: TouristInfoBinding) = with(binding) {
        root.bind(
            isExpanded,
            number,
            firstName,
            lastName,
            dateOfBirth,
            citizenship,
            passportNumber,
            passportValidityPeriod
        )
    }
}

class ExpandingChanged(private val isExpanded: Boolean) : Payload<TouristInfoBinding> {
    override fun bindPayload(binding: TouristInfoBinding) {
        binding.root.bindExpanding(isExpanded)
    }
}