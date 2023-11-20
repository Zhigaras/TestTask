package com.zhigaras.booking.ui.customViews.input

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import com.zhigaras.booking.ui.customViews.InputValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class AbstractEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputEditText(context, attrs, defStyleAttr), InputValidation {
    
    protected abstract val customInputType: Int
    protected abstract fun innerIsValid(): Boolean
    private val regularBgColor = context.getColor(com.zhigaras.uikit.R.color.white30)
    private val errorBgColor = context.getColor(com.zhigaras.uikit.R.color.red_15percent)
    private val validationFlow = MutableStateFlow(true)
    
    fun text(): String = (text ?: "").toString().trim()
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inputType = customInputType
        doOnTextChanged { _, _, _, _ -> validationFlow.value = true }
        findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
            validationFlow.collect { isValid ->
                backgroundTintList = ColorStateList(
                    arrayOf(intArrayOf()), intArrayOf(if (isValid) regularBgColor else errorBgColor)
                )
            }
        }
    }
    
    override fun isValid(): Boolean {
        val isValid = innerIsValid()
        validationFlow.value = isValid
        return isValid
    }
    
    companion object {
        /**
         * pattern includes dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy formats
         */
        internal const val DATE_PATTERN =
            "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$"
    }
}