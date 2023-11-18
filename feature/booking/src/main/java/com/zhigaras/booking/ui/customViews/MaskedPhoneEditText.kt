package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.google.android.material.textfield.TextInputEditText

class MaskedPhoneEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputEditText(context, attrs, defStyleAttr) {
    
    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        Log.d(
            "WWWWW on",
            "$text, start = $start, lengthBefore = $lengthBefore, lengthAfter = $lengthAfter"
        )
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setOnFocusChangeListener { v, hasFocus ->
            hint = if (hasFocus) MASK else null
        }
    }
    
    companion object {
        private const val MASK = "+7 (***) ***-**-**"
    }
}