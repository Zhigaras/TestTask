package com.zhigaras.rooms.ui.model

class RoomUiModel(
    private val id: Int,
    private val imageUrls: List<String>,
    private val name: String,
    private val peculiarities: List<String>,
    private val price: Int,
    private val priceUnit: String,
) {
}