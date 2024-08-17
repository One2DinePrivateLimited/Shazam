package com.one2dine.shazam.helpers

import com.one2dine.shazam.constants.BASE_URL
import com.one2dine.shazam.constants.PRINT_LOGS
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get


internal object ServerURL {
    private val settings: Settings = com.russhwolf.settings.Settings()


    fun setServerURL(baseURL: String) {
        settings.putString(BASE_URL, baseURL)
    }

    fun getBaseURL(): String {
        return settings[BASE_URL, ""]
    }

    fun printLogs(print: Boolean) {
        settings.putBoolean(PRINT_LOGS, print)
    }

    fun getPrintLogs(): Boolean {
        TODO()
    }

}