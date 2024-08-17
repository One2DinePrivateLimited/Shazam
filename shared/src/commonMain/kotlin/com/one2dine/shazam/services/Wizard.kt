package com.one2dine.shazam.services

import com.one2dine.shazam.constants.APIEventType
import io.ktor.http.Headers


object Wizard{
    inline fun <reified requestType, urlParameterType, reified responseType> makeHTTPCall(
        apiEventType: APIEventType,
        headers: Headers,
        request: requestType,
        urlParams: urlParameterType,
        crossinline success: (Double, responseType) -> Unit,
        crossinline failure: (String) -> Unit
    ){
        APIServices.makeHTTPCall<requestType, urlParameterType,responseType>(
            headers,
            apiEventType,
            request,
            urlParams,
            success,
            failure
        )

    }
}