package com.one2dine.shazam.dataModel.requestModels

import kotlinx.serialization.SerialName

data class MenuRequest(
    @SerialName("restId")
    val restaurantId: String
)