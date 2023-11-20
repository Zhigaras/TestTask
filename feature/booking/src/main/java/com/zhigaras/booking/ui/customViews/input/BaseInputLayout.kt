package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.zhigaras.booking.ui.customViews.InputValidation

class BaseInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr), InputValidation {
    
    fun setText(text: String) {
        editText?.setText(text)
    }
    
    fun text() = (editText?.text ?: "").toString()
    
    override fun isValid(): Boolean {
        return (editText as InputValidation).isValid()
    }
    
    override fun setOnFocusChangeListener(l: OnFocusChangeListener?) {
        editText?.onFocusChangeListener = l
    }
    
    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle().also {
            it.putParcelable("superState", super.onSaveInstanceState())
            it.putParcelable("editText", editText?.onSaveInstanceState())
        }
        return bundle
    }
    
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            editText?.onRestoreInstanceState(state.getParcelable("editText"))
            super.onRestoreInstanceState(state.getParcelable("superState"))
        } else {
            super.onRestoreInstanceState(state)
        }
    }
}