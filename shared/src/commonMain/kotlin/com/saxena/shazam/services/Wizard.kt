package com.saxena.shazam.services

import com.saxena.shazam.constants.APIEventType
import com.saxena.shazam.dataModel.requestModels.MenuRequest
import io.ktor.http.Headers


object Wizard{
    fun <requestType, urlParameterType, responseType> makeHTTPCall(
        apiEventType: APIEventType,
        headers: Headers,
        request: requestType,
        urlParams: urlParameterType,
        success: (Double, responseType) -> Unit,
        failure: (String) -> Unit
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