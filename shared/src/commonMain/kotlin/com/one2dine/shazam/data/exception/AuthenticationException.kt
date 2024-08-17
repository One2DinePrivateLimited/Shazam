package com.one2dine.shazam.data.exception

class AuthenticationException(
    code: Int,
    errorBody: String
) : ApiException(code, errorBody) {

    override var message: String? = null
        get() = "Authentication Failed! Error Code: $code"

}
