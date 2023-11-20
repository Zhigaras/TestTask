package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

abstract class AbstractInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr), InputValidation {
    
    protected abstract fun innerIsValid(): Boolean
    
    abstract fun setInputType(fieldIndex: Int)
    
    override fun text(): String = (editText?.text ?: "").toString().trim()
    
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
        if (!isValid) setBackgroundColor(context.getColor(com.zhigaras.uikit.R.color.red_15percent))
        return isValid
    }
}