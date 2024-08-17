package com.one2dine.shazam.data.model.request

import kotlinx.serialization.SerialName

data class MenuRequest(
    @SerialName("restaurant_id")
    val restaurantId: String
)

data class MenuCategory(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String

)