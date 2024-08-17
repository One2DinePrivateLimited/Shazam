package com.one2dine.shazam.data.services

import com.one2dine.shazam.ApplicationDispatcher
import com.one2dine.shazam.data.network.RequestBuilder
import com.one2dine.shazam.constants.APIEventType

import com.one2dine.shazam.data.model.response.MenuData
import com.one2dine.shazam.data.model.request.MenuRequest

import io.ktor.http.Headers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

object APIServices {

    private val coroutineScope = CoroutineScope(SupervisorJob() + ApplicationDispatcher)

    inline fun <reified requestType, urlParameterType, reified responseType> makeHTTPCall(
        headers: Headers,
        apiEventType: APIEventType,
        request: requestType,
        urlParams: urlParameterType,
        crossinline success: (Double, responseType) -> Unit,
        crossinline failure: (String) -> Unit

    ) {


        RequestBuilder.createHTTPResponse(
            apiEventType,
            apiType = TODO(),
            header = TODO(),
            urlParams = TODO(),
            requestBody = request,
            success = success,
            failure = failure,

            )
//        when(apiEventType){
//
//            REQ_OTP -> TODO()
//            LOGIN -> TODO()
//            SIGN_UP -> TODO()
//
//            GET_MENU -> getRestrauntMenu(
//                headers,
//                request as MenuRequest,
//                success as (Double, MenuData) -> Unit, failure
//            )
//
//            ADD_MENU -> TODO()
//            UPDATE_MENU -> TODO()
//            ADD_CATEGORY -> TODO()
//            UPDATE_MENU_AVAILABILITY -> TODO()
//        }


    }

    private fun getRestrauntMenu(
        headers: Headers,
        request: MenuRequest,
        success: (Double, MenuData) -> Unit,
        failure: (String) -> Unit
    ) {

    }

    private fun addMenu(
        headers: Headers,
        request: MenuRequest,
        success: (Double, MenuData) -> Unit,
        failure: (String) -> Unit
    ) {

    }

}