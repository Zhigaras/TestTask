package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.zhigaras.booking.ui.customViews.InputValidation

class BaseInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr), InputValidation {
    
    override fun isValid(): Boolean {
        return (editText as InputValidation).isValid()
    }
}