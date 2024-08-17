package com.one2dine.shazam.data.exception

import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

open class ApiException(
    val code: Int,
    errorBody: String,
    innerException: Throwable? = null
) : IOException(innerException.toString()) {

    override var message: String? = null
    var errorDetails: Map<String, Any>? = null

    init {
        try {
            val json = Json { ignoreUnknownKeys = true }
            val errMap: Map<String, Any>? = json.decodeFromString(errorBody)

            errMap?.let {
                message = it["errorMessage"]?.toString()?.split("\n")?.firstOrNull()
                errorDetails = it["error"] as? Map<String, Any>
            }
        } catch (err: SerializationException) {
            message = "An error occurred while processing the response."
            errorDetails = mapOf("error" to "JSON parsing failed: ${err.message}")
        }
    }
}
