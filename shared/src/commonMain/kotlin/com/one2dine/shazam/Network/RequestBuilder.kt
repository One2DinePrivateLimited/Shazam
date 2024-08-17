package com.one2dine.shazam.Network

import com.one2dine.shazam.ApplicationDispatcher
import com.one2dine.shazam.constants.APIEventType
import com.one2dine.shazam.constants.NO_RESPONSE
import com.one2dine.shazam.constants.RequestType
import com.one2dine.shazam.constants.getAPIURL
import com.one2dine.shazam.dataModel.errorModel.CustomError
import com.one2dine.shazam.dataModel.errorModel.ErrorModel
import com.one2dine.shazam.dataModel.requestModels.Header
import com.one2dine.shazam.helpers.HTTPClientService
import io.ktor.*
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.append
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

object RequestBuilder {


     inline fun <reified requestType, reified responseType> createHTTPResponse(
        eventType: APIEventType,
        apiType: RequestType,
        header: Header,
        urlParams: String = "",
        requestBody: requestType?,
        crossinline success: (Double, responseType) -> Unit,
        crossinline failure: (String?) -> Unit
    ) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                var apiResponseTime  = 0.0

                try{
                    if (header.token != ""){
//                        val rawResult = when (eventType) {
//                            APIEventType.REQ_OTP -> {
//                                val request = requestBody
//
//                            }
//                            APIEventType.LOGIN -> TODO()
//                            APIEventType.SIGN_UP -> TODO()
//
//                            APIEventType.GET_MENU -> {
//
//                            }
//                            APIEventType.ADD_MENU -> TODO()
//                            APIEventType.UPDATE_MENU -> TODO()
//                            APIEventType.ADD_CATEGORY -> TODO()
//                            APIEventType.UPDATE_MENU_AVAILABILITY -> TODO()
//
//                        }

                        val rawResult = makeAPICall<requestType,responseType>(
                            eventType,
                            apiType,
                            header,
                            arrayOf(urlParams),
                            requestBody
                        )


                    }
                }catch (se : ServerResponseException){
                    se.message.let {
//                    printLogs(it)
                    }

                    failure(
                        CustomError(
                            se.response.status.value,
                            getErrorMessage(se.response),
                            responseTime(se.response)
                        ).toString()
                    )
                }
            }




        }

    }
}

suspend fun getErrorMessage(httpResponse: HttpResponse): String{
    return try {
        getErrorMessage(httpResponse.bodyAsText())
    }catch (e: Exception){
        NO_RESPONSE
    }
}

fun getErrorMessage(message: String): String{
    return if (message.isNullOrEmpty() && message.trim().startsWith("{")){
        try {
            val pt = Json.decodeFromString<ErrorModel>(message)
            if (!pt.message.isNullOrEmpty())
                pt.message
            else if (!pt.error.isNullOrEmpty())
                pt.error
            else
                message
        }catch (ex: Exception){
            NO_RESPONSE
        }
    }else
        NO_RESPONSE
}

fun responseTime(result: HttpResponse): Double{
    return ((result.responseTime.timestamp - result.requestTime.timestamp).toDouble()/ 100f)
}

suspend inline fun <reified  requestType, reified responseType> makeAPICall(
    eventType: APIEventType,
    apiType: RequestType,
    header: Header,
    urlParams: Array<String>,
    requestBody: requestType?,
): HttpResponse{
    val httpClient = HTTPClientService.httpClient
    val apiURL = getAPIURL(method = eventType, urlParams, header.route)
    val builder: HttpRequestBuilder = HttpRequestBuilder().apply {
        contentType(ContentType.Application.Json)
        headers {
            append(HttpHeaders.Authorization, header.token)
        }
        url(apiURL)
        if (requestBody != null){
            setBody(requestBody)
        }
    }

    val rawResult: HttpResponse = when(apiType){
        RequestType.GET -> httpClient.get(builder)
        RequestType.POST -> httpClient.post(builder)
        RequestType.PUT -> httpClient.put(builder)
        RequestType.DELETE -> httpClient.delete(builder)
    }

    return rawResult
}
