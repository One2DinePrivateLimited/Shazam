package com.saxena.shazam.services

import com.saxena.shazam.ApplicationDispatcher
import com.saxena.shazam.constants.APIEventType

import com.saxena.shazam.constants.APIEventType.MENU
import com.saxena.shazam.constants.APIEventType.REQ_OTP
import com.saxena.shazam.constants.APIEventType.LOGIN
import com.saxena.shazam.constants.APIEventType.SIGN_UP
import com.saxena.shazam.dataModel.models.MenuData
import com.saxena.shazam.dataModel.requestModels.MenuRequest

import io.ktor.http.Headers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

internal object APIServices {

    private val coroutineScope = CoroutineScope(SupervisorJob() + ApplicationDispatcher)

    fun <requestType, urlParameterType, responseType> makeHTTPCall(
        headers: Headers,
        apiEventType: APIEventType,
        request: requestType,
        urlParams: urlParameterType,
        success: (Double, responseType) -> Unit,
        failure: (String) -> Unit

    ){

        when(apiEventType){
            MENU -> getRestrauntMenu(
                headers,
                request as MenuRequest,
                success as (Double, MenuData) -> Unit, failure
            )



            REQ_OTP -> TODO()
            LOGIN -> TODO()
            SIGN_UP -> TODO()
        }


    }

    private fun getRestrauntMenu(
        headers: Headers,
        request: MenuRequest,
        success: (Double, MenuData) -> Unit,
        failure: (String) -> Unit
    ){

    }

}