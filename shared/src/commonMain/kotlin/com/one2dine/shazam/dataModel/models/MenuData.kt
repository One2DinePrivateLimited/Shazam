package com.one2dine.shazam.dataModel.models

import kotlinx.serialization.Serializable

@Serializable
data class MenuData(
    val restaurantId: String,
    val menu: List<String>

)