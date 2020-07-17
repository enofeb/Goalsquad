package com.example.core.base.error

sealed class Error {
    data class UnknownError(val message: String? = null) : Error()
}