package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import com.zhigaras.booking.R
import com.zhigaras.booking.ui.customViews.input.BaseInputLayout
import com.zhigaras.booking.ui.model.ParcelableBuyerInfo

class BuyerInfoLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractLinearLayout(context, attrs, defStyleAttr) {
    
    private val phoneInput by lazy { findViewById<BaseInputLayout>(R.id.phone_input) }
    private val emailInput by lazy { findViewById<BaseInputLayout>(R.id.email_input) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        emailInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) emailInput.isValid()
        }
    }

    fun provideInfo() = ParcelableBuyerInfo(phoneInput.text(), emailInput.text())
    
    fun restoreData(state: ParcelableBuyerInfo) {
        phoneInput.setText(state.phoneNumber)
        emailInput.setText(state.email)
    }
}