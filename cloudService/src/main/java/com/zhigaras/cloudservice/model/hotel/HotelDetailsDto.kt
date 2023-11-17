package com.zhigaras.cloudservice.model.hotel


import com.google.gson.annotations.SerializedName

data class HotelDetailsDto(
    @SerializedName("about_the_hotel")
    val aboutTheHotel: AboutTheHotelDto,
    @SerializedName("adress")
    val address: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
    @SerializedName("minimal_price")
    val minimalPrice: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_for_it")
    val priceForIt: String,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("rating_name")
    val ratingName: String
)