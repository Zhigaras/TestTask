package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isVisible
import com.zhigaras.booking.R

class TouristInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val touristInfoList = resources.getStringArray(R.array.tourist_info)
    private val touristCountList = resources.getStringArray(R.array.tourist_count)
    private val expandButton by lazy { findViewById<ImageView>(R.id.expand_button) }
    private val viewToHide by lazy { findViewById<LinearLayout>(R.id.view_to_hide) }
    private val inputFields by lazy { viewToHide.children.toList() }
    private val touristNumberTextView by lazy { findViewById<TextView>(R.id.tourist_number_text_view) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        
        inputFields.zip(touristInfoList).forEach { (view, hint) ->
            (view as BaseInputLayout).hint = hint
        }
    }
    
    fun setOnExpandClickListener(listener: OnClickListener?) {
        expandButton.setOnClickListener(listener)
    }
    
    fun bind(isExpanded: Boolean, number: Int, vararg input: String) {
        bindExpanding(isExpanded)
        touristNumberTextView.text = touristCountList[number - 1]
        inputFields.zip(input).forEach { (view, string) ->
            (view as BaseInputLayout).setText(string)
        }
    }
    
    fun bindExpanding(isExpanded: Boolean) {
        viewToHide.isVisible = isExpanded
        expandButton.rotation = if (isExpanded) 180f else 0f
    }
}