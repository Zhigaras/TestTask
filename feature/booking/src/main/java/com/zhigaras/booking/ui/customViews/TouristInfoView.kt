package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.zhigaras.booking.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TouristInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val expandedFlow = MutableStateFlow(false)
    private val expandButton by lazy { findViewById<ImageView>(R.id.expand_button) }
    private val viewToHide by lazy { findViewById<LinearLayout>(R.id.view_to_hide) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        expandButton.setOnClickListener {
            expandedFlow.value = !expandedFlow.value
        }
        
        findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
            expandedFlow.collect {
                viewToHide.isVisible = it
            }
        }
    }
}