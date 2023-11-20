package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.view.children
import com.zhigaras.booking.ui.customViews.inputLayouts.InputValidation

class BuyerInfoLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), InputValidation {
    
    override fun isValid(): Boolean {
        val childValidationList = children.filterIsInstance<InputValidation>().map { it.isValid() }
        return childValidationList.toList().all { it }
    }
}