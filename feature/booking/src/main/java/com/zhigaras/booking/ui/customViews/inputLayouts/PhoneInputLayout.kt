package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import com.zhigaras.booking.R
import kotlin.random.Random

class PhoneInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_CLASS_PHONE
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        hint = context.getString(R.string.phone_number)
    }
    
    override fun innerIsValid(): Boolean {
        return Random.nextBoolean() // TODO: replace with validation
    }
}