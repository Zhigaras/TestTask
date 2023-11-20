package com.zhigaras.cloudservice.model.rooms


import com.google.gson.annotations.SerializedName

data class RoomsInfoDto(
    @SerializedName("rooms")
    val rooms: List<RoomDto>
)