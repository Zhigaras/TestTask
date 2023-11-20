package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet

open class BaseInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_TEXT_FLAG_CAP_WORDS
    
    override fun innerIsValid(): Boolean {
        return editText?.text.isNullOrBlank().not()
    }
}
