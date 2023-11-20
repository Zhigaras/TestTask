package com.zhigaras.booking.ui.model

import android.os.Parcelable
import com.zhigaras.adapterdelegate.ListItem
import kotlinx.parcelize.Parcelize

@Parcelize
class TouristInfoUiModel(
    val number: Int,
    val isExpanded: Boolean,
    val params: List<String>
) : ListItem, Parcelable {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return number == other.number
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is TouristInfoUiModel) return false
        return true // TODO: check
    }
}