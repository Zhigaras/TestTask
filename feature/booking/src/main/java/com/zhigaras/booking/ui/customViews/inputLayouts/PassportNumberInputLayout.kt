package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import androidx.core.text.isDigitsOnly

class PassportNumberInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_CLASS_NUMBER
    
    override fun innerIsValid(): Boolean {
        return text().isDigitsOnly()
    }
}