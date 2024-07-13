package com.saxena.shazam.constants

import com.saxena.shazam.constants.APIPath.REQ_OTP
import com.saxena.shazam.helpers.ServerURL

enum class RequestType {
    GET,
    POST,
    PUT,
    DELETE
}

enum class SourceApp {
    Android,
    iOS,
    WebApp
}
enum class APIEventType{
    REQ_OTP,
    LOGIN,
    SIGN_UP
}

object APIPath{
    const val REQ_OTP = "/"
    const val LOGIN = "/"
    const val SIGN_UP = "/"
}

fun getAPIURL(method: APIEventType, route: String): String{
    val baseURL = ServerURL.getBaseURL()

    return when(method){
        APIEventType.REQ_OTP -> "$baseURL$route$REQ_OTP"
        APIEventType.LOGIN -> TODO()
        else -> {
            return ""
        }
    }
}

