package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

open class BaseInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr) {
    
    fun setText(string: String) {
        editText?.setText(string)
    }
}
