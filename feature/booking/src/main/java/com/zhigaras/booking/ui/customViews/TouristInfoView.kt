package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isVisible
import com.zhigaras.booking.R
import com.zhigaras.booking.ui.customViews.inputLayouts.AbstractInputLayout

class TouristInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val touristInfoList = resources.getStringArray(R.array.tourist_info)
    private val touristCountList = resources.getStringArray(R.array.tourist_count)
    private val expandButton by lazy { findViewById<ImageView>(R.id.expand_button) }
    private val viewToHide by lazy { findViewById<LinearLayout>(R.id.view_to_hide) }
    private val inputFields by lazy { viewToHide.children.toList() as List<AbstractInputLayout> }
    private val touristNumberTextView by lazy { findViewById<TextView>(R.id.tourist_number_text_view) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        
        inputFields.zip(touristInfoList).forEachIndexed { index, (view, hint) ->
            view.hint = hint
            view.setInputType(index)
        }
    }
    
    fun setOnExpandClickListener(listener: OnClickListener?) {
        expandButton.setOnClickListener(listener)
    }
    
    fun setTypingListeners(action: (Int, String) -> Unit) {
        inputFields.forEachIndexed { index, view ->
            view.setTypingListener {
                action.invoke(index, it)
            }
        }
    }
    
    fun bind(isExpanded: Boolean, number: Int, touristParams: List<String>) {
        bindExpanding(isExpanded)
        touristNumberTextView.text = touristCountList[number - 1]
        inputFields.zip(touristParams).forEach { (view, param) ->
            view.setText(param)
        }
    }
    
    fun bindExpanding(isExpanded: Boolean) {
        viewToHide.isVisible = isExpanded
        expandButton.rotation = if (isExpanded) 0f else 180f
    }
}