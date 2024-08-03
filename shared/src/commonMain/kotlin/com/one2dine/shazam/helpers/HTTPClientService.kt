package com.one2dine.shazam.helpers

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer.Companion.DefaultJson
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.Configuration
import kotlinx.serialization.Serializable


//val json by lazy {
//    kotlinx.serialization.json.Json {
//        prettyPrint = true
//        isLenient = true
//        ignoreUnknownKeys = true
//    }
//}

object HTTPClientService {

    val httpClient = HttpClient {
        install(ContentNegotiation) {
//            kotlinx.serialization.json.Json
//           json(json)
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
//               level = Loglevel.ALL
            }
        }
    }

}


