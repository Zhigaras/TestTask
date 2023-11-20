package com.zhigaras.booking.ui.customViews.inputLayouts

import android.content.Context
import android.text.InputType
import android.util.AttributeSet

class DateOfBirthInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {
    
    override fun setInputType(fieldIndex: Int) {
        editText?.inputType = InputType.TYPE_CLASS_NUMBER
    }
    
    override fun innerIsValid(): Boolean {
        return Regex(DATE_PATTERN).matches(text())
    }
    
    companion object {
        /**
         * pattern includes dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy formats
         */
        private const val DATE_PATTERN =
            "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$"
    }
}