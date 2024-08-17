package com.one2dine.shazam.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Header(
    @SerialName("token")
    val token: String,
    @SerialName("route")
    val route: String

)