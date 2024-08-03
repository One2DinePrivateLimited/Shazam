package com.one2dine.shazam.constants

import com.one2dine.shazam.constants.APIPath.REQ_OTP
import com.one2dine.shazam.helpers.ServerURL

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
    SIGN_UP,
    MENU
}

object APIPath{
    const val REQ_OTP = "/"
    const val LOGIN = "/"
    const val SIGN_UP = "/"
    const val  MENU = "/"
}

fun getAPIURL(method: APIEventType, route: String): String{
    val baseURL = ServerURL.getBaseURL()

    return when(method){
        APIEventType.REQ_OTP -> "$baseURL$route$REQ_OTP"
        APIEventType.LOGIN -> TODO()
        APIEventType.MENU -> TODO()
        else -> {
            return ""
        }
    }
}

