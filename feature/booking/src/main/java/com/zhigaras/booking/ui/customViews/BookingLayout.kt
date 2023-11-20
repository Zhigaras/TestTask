package com.zhigaras.booking.ui.customViews

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.zhigaras.booking.R
import com.zhigaras.booking.ui.model.ParcelableUiModel

class BookingLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractLinearLayout(context, attrs, defStyleAttr) {
    
    private val buyerInfoLayout by lazy { findViewById<BuyerInfoLayout>(R.id.buyer_info_layout) }
    private val firstTourist by lazy { findViewById<TouristInfoLayout>(R.id.tourist_info_layout) }
    private val addTouristView by lazy { findViewById<LinearLayout>(R.id.add_tourist_layout) }
    private val addTouristButton by lazy { findViewById<ImageView>(R.id.add_tourist_button) }
    private val tourists by lazy { mutableListOf<TouristInfoLayout>(firstTourist) }
    
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        firstTourist.bind(true, 0)
        addTouristButton.setOnClickListener {
            addTourist()
        }
    }
    
    private fun addTourist() {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.tourist_info, this, false) as TouristInfoLayout
        tourists.add(view)
        view.bind(false, tourists.lastIndex)
        addView(view, indexOfChild(addTouristView))
        if (tourists.size == MAX_TOURISTS_COUNT) addTouristView.visibility = View.GONE
    }
    
    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putParcelable("superState", super.onSaveInstanceState())
        bundle.putParcelable(
            "save",
            ParcelableUiModel(buyerInfoLayout.provideInfo(), tourists.map { it.provideInfo() })
        )
        return bundle
    }
    
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            restore(state.getParcelable("save"))
            super.onRestoreInstanceState(state.getParcelable("superState"))
        } else {
            super.onRestoreInstanceState(state)
        }
    }
    
    private fun restore(state: Parcelable?) {
        (state as? ParcelableUiModel)?.let { savedState ->
            buyerInfoLayout.restoreData(savedState.buyerInfo)
            repeat(state.tourists.size - tourists.size) { addTourist() }
            tourists.zip(state.tourists).forEach { (view, tourist) ->
                view.restoreData(tourist)
            }
        }
    }
    
    companion object {
        private const val MAX_TOURISTS_COUNT = 5
    }
}