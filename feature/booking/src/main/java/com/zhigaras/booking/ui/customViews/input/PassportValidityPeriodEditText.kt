package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.text.InputType
import android.util.AttributeSet

class PassportValidityPeriodEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractEditText(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_CLASS_DATETIME
    
    override fun innerIsValid(): Boolean {
        return Regex(DATE_PATTERN).matches(text())
    }
}