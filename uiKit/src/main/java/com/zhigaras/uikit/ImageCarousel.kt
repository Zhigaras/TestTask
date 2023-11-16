package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhigaras.uikit.databinding.ImageCarouselBinding

class ImageCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    
    private val binding = ImageCarouselBinding.inflate(LayoutInflater.from(context), this)
    private val mediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }
    
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
//        addView(binding.root)
    }
    
    fun setImages(list: List<String>) {
        binding.viewPager.adapter = CarouselAdapter(list)
        mediator.attach()
    }
    
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mediator.detach()
    }
}