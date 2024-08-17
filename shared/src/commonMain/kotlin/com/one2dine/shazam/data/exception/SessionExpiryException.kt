package com.one2dine.shazam.data.exception

import io.ktor.utils.io.errors.IOException

class SessionExpiryException(
    message: String = "Session has expired."
) : IOException(message)
