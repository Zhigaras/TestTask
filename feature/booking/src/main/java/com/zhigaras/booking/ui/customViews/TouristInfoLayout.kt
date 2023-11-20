package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.zhigaras.booking.R
import com.zhigaras.booking.ui.customViews.input.BaseInputLayout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TouristInfoLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractLinearLayout(context, attrs, defStyleAttr) {
    
    private val expandedFlow = MutableStateFlow(true)
    private val touristHintsList = resources.getStringArray(R.array.tourist_hints)
    private val touristCountList = resources.getStringArray(R.array.tourist_count)
    private val expandButton by lazy { findViewById<ImageView>(R.id.expand_button) }
    private val payload by lazy { findViewById<TouristInfoPayloadLayout>(R.id.view_to_hide) }
    private val touristNumberTextView by lazy { findViewById<TextView>(R.id.tourist_number_text_view) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        expandButton.setOnClickListener {
            expandedFlow.value = !expandedFlow.value
        }
        payload.children.toList().zip(touristHintsList).forEach { (view, hint) ->
            (view as BaseInputLayout).hint = hint
        }
        
        findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
            expandedFlow.collect { isExpanded ->
                payload.isVisible = isExpanded
                expandButton.rotation = if (isExpanded) 0f else 180f
            }
        }
    }
    
    override fun isValid(): Boolean {
        return payload.isValid()
    }
    
    fun bind(isExpanded: Boolean, number: Int) {
        expandedFlow.value = isExpanded
        touristNumberTextView.text = touristCountList[number]
    }
}