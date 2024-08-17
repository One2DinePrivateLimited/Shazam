package com.one2dine.shazam.dataModel.requestModels

import kotlinx.serialization.SerialName

data class MenuRequest(
    @SerialName("restId")
    val restaurantId: String
)

data class MenuCategory(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String

)