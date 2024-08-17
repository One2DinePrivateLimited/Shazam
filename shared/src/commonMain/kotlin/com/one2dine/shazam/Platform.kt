package com.one2dine.shazam
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform