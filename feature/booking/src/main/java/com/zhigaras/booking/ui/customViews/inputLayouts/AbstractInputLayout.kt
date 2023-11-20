package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

abstract class AbstractInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr), InputValidation {
    
    protected abstract val customInputType: Int
    
    protected abstract fun innerIsValid(): Boolean
    
    fun text(): String = (editText?.text ?: "").toString().trim()
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        editText?.inputType = customInputType
    }
    
    fun setText(string: String) {
        editText?.setText(string)
    }
    
    fun setTypingListener(action: (String) -> Unit) {
        editText?.doOnTextChanged { text, _, _, _ ->
            action.invoke(text.toString())
        }
    }
    
    override fun isValid(): Boolean {
        val isValid = innerIsValid()
        if (!isValid) editText?.backgroundTintList = ColorStateList(
            arrayOf(intArrayOf()),
            intArrayOf(context.getColor(com.zhigaras.uikit.R.color.red_15percent))
        )
        return isValid
    }
}