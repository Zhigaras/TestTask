package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import kotlin.random.Random

class PhoneEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractEditText(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_CLASS_PHONE
    
    override fun innerIsValid(): Boolean {
        return Random.nextBoolean() // TODO: replace with validation
    }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setOnFocusChangeListener { _, hasFocus ->
            hint = if (hasFocus) MASK else null
        }
    }
    
    companion object {
        private const val MASK = "+7 (***) ***-**-**"
    }
}