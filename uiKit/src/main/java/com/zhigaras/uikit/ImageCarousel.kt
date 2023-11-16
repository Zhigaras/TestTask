package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ImageCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    
    private val viewPager by lazy { findViewById<ViewPager2>(R.id.view_pager) }
    private val tabLayout by lazy { findViewById<TabLayout>(R.id.tab_layout) }
    private val mediator by lazy { TabLayoutMediator(tabLayout, viewPager) { _, _ -> } }
    
    fun setImages(list: List<String>) {
        viewPager.adapter = CarouselAdapter(list)
        mediator.attach()
    }
    
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mediator.detach()
    }
}