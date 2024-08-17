package com.one2dine.shazam.data.exception

class BadInputException(code: Int, errorBody: String) : ApiException(code, errorBody) {
    val errorFields = mutableListOf<Any>()

    init {
        try {
            if (errorDetails != null && errorDetails?.containsKey("errorFields") == true) {
                val errorFieldsValue = errorDetails?.get("errorFields")
                if (errorFieldsValue is List<*>) {
                    errorFields.addAll(errorFieldsValue.filterIsInstance<Any>())
                } else {
                    if (errorFieldsValue != null) {
                        errorFields.add(errorFieldsValue)
                    }
                }
            }
        } catch (err: Exception) {
            // Handle any error here
        }
    }

    constructor(errorFields: List<Any>) : this(400, errorFields.joinToString(", ") + " are missing")
}
