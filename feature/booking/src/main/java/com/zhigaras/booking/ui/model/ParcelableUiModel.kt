package com.zhigaras.booking.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ParcelableUiModel(
    val buyerInfo: ParcelableBuyerInfo,
    val tourists: List<TouristInfoUiModel>
) : Parcelable

@Parcelize
class ParcelableBuyerInfo(
    val phoneNumber: String,
    val email: String,
) : Parcelable