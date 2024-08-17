package com.one2dine.shazam.data.model.error

class RequestException(val code: Int, message: String) : Throwable(message)