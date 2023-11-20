package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.Patterns

class EmailEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractEditText(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
    
    override fun innerIsValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(text()).matches()
    }
}