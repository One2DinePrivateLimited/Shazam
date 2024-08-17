package com.one2dine.shazam.dataModel.requestModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Header(
    @SerialName("token")
    val token: String,
    @SerialName("route")
    val route: String

)