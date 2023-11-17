package com.zhigaras.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class PeculiaritiesChipGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ChipGroup(context, attrs, defStyleAttr) {
    
    fun setPeculiarities(pecs: List<String>) {
        pecs.forEach { peculiarity ->
            val chip = LayoutInflater.from(context).inflate(
                R.layout.peculiarities_single_chip,
                this,
                false
            ) as Chip
            chip.text = peculiarity
            addView(chip)
        }
    }
}