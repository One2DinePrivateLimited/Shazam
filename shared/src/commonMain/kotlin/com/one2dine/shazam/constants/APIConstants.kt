package com.one2dine.shazam.constants

import com.one2dine.shazam.constants.APIPath.ADD_CATEGORY
import com.one2dine.shazam.constants.APIPath.MENU
import com.one2dine.shazam.constants.APIPath.REQ_OTP
import com.one2dine.shazam.constants.APIPath.RESTAURANTS
import com.one2dine.shazam.constants.APIPath.UPDATE_MENU_AVAILABILITY
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
    GET_MENU,
    ADD_MENU,
    UPDATE_MENU,
    ADD_CATEGORY,
    UPDATE_MENU_AVAILABILITY
}

object APIPath{
    const val REQ_OTP = "/"
    const val LOGIN = "/"
    const val SIGN_UP = "/"
    const val MENU = "/menu"
    const val RESTAURANTS = "/restaurants"
    const val GET_MENU = ""
    const val ADD_MENU = ""
    const val UPDATE_MENU= "/restaurants"
    const val ADD_CATEGORY = "/category"
    const val UPDATE_MENU_AVAILABILITY = "/availability"
}

fun getAPIURL(method: APIEventType, params: Array<String>,  route: String): String{
    val baseURL = ServerURL.getBaseURL()

    return when(method){
        APIEventType.REQ_OTP -> "$baseURL$route$REQ_OTP"
        APIEventType.LOGIN -> TODO()

        APIEventType.GET_MENU -> "$baseURL$route$RESTAURANTS/${params.get(0)}$MENU"
        APIEventType.ADD_MENU -> "$baseURL$route$RESTAURANTS/${params.get(0)}$MENU"
        APIEventType.UPDATE_MENU -> "$baseURL$route$RESTAURANTS/${params.get(0)}$MENU/${params.get(1)}"
        APIEventType.ADD_CATEGORY -> "$baseURL$route$RESTAURANTS/${params.get(0)}$MENU/$ADD_CATEGORY"
        APIEventType.UPDATE_MENU_AVAILABILITY -> "$baseURL$route$RESTAURANTS/${params.get(0)}/$MENU/${params.get(1)}$UPDATE_MENU_AVAILABILITY"


        else -> {
            return ""
        }
    }
}


