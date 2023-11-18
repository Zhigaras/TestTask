package com.zhigaras.booking.ui.model

import com.google.android.material.button.MaterialButton
import com.zhigaras.adapterdelegate.ListItem
import com.zhigaras.booking.databinding.TourPriceLayoutBinding
import com.zhigaras.uikit.R

data class TourPriceUiModel(
    private val tourId: Int,
    private val tourPrice: String,
    private val fuelCharge: String,
    private val serviceCharge: String,
    private val totalPrice: String
) : ListItem {
    
    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is TourPriceUiModel) return false
        return tourId == other.tourId
    }
    
    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is TourPriceUiModel) return false
        return this == other
    }
    
    fun bind(binding: TourPriceLayoutBinding) = with(binding) {
        tourPriceValue.text = root.context.getString(R.string.price_exact, tourPrice)
        fuelChargeValue.text = root.context.getString(R.string.price_exact, fuelCharge)
        serviceChargeValue.text = root.context.getString(R.string.price_exact, serviceCharge)
        totalPriceValue.text = root.context.getString(R.string.price_exact, totalPrice)
    }
    
    fun bindPayButton(button: MaterialButton) = with(button) {
        text = context.getString(com.zhigaras.booking.R.string.pay_button_text, totalPrice)
    }
}