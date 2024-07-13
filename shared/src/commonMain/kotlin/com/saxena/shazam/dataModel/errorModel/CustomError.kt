package com.saxena.shazam.dataModel.errorModel

import com.saxena.shazam.constants.NA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CustomError(
    val errorCode: Int = 248,
    val errorMessage: String,
    val responseTime: Double = 0.0
)

@Serializable
data class ErrorModel(
    @SerialName("status")
    val status: String? = NA,
    @SerialName("status")
    val message: String? = NA,
    @SerialName("status")
    val error: String? = NA
)

