package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import kotlin.random.Random

class PhoneInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override fun setInputType(fieldIndex: Int) {
        editText?.inputType = InputType.TYPE_CLASS_PHONE
    }
    
    override fun innerIsValid(): Boolean {
        return Random.nextBoolean() // TODO: replace with validation
    }
}