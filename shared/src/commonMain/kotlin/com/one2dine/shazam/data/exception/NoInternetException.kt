package com.one2dine.shazam.data.exception

import io.ktor.utils.io.errors.IOException

class NoInternetException(
    message: String = "No internet connection available."
) : IOException(message)
