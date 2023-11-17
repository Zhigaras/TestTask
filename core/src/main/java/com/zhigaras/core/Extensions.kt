package com.zhigaras.core

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun Int.formatPrice(): String {
    val formatSymbols = DecimalFormatSymbols()
    formatSymbols.groupingSeparator = ' '
    return DecimalFormat("###,###", formatSymbols).format(this)
}