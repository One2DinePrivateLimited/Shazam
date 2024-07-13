package com.saxena.shazam

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform