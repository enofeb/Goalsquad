package com.example.core.base.error

import com.google.gson.annotations.SerializedName

sealed class Error {

    data class UnknownError(val message: String? = null) : Error()

    data class ApiError(
        @SerializedName("type") val type: String? = null,
        @SerializedName("message") val message: String? = null
    ) : Error()

}