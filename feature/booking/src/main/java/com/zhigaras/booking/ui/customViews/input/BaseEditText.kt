package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.text.InputType
import android.util.AttributeSet

class BaseEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractEditText(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_TEXT_FLAG_CAP_WORDS
    
    override fun innerIsValid(): Boolean {
        return text().isNotBlank()
    }
}