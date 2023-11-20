package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

open class BaseInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr) {
    
    fun setText(string: String) {
        editText?.setText(string)
    }
    
    fun setTypingListener(action: (String) -> Unit) {
        editText?.doOnTextChanged { text, _, _, _ ->
            action.invoke(text.toString())
        }
    }
    
    fun setInputType(fieldIndex: Int) {
        editText?.inputType = when (fieldIndex) {
            2 -> InputType.TYPE_CLASS_DATETIME
            4 -> InputType.TYPE_CLASS_NUMBER
            5 -> InputType.TYPE_CLASS_DATETIME
            else -> InputType.TYPE_TEXT_FLAG_CAP_WORDS
        }
    }
}
