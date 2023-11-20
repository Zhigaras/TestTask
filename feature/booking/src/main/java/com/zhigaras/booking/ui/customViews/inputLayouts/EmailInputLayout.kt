package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.Patterns
import com.zhigaras.booking.R

class EmailInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override val customInputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        hint = context.getString(R.string.email)
    }
    
    override fun innerIsValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(text()).matches()
    }
}