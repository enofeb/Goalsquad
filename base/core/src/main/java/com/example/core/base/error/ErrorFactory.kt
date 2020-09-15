package com.example.core.base.error

import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.HttpException
import java.lang.Exception
import com.example.core.base.error.Error.UnknownError
import com.example.core.base.error.Error.ApiError

interface ErrorFactory {

    fun createUnknownError(): Error = UnknownError()

    fun createApiError(errorBody: String): Error {
        return Gson().fromJson(JSONObject(errorBody).toString(), ApiError::class.java)
    }

    fun createApiError(e: Exception): Error {
        return when (e) {
            is HttpException -> {
                createApiError(e.response()?.errorBody()!!.string())
            }
            else -> {
                createUnknownError()
            }
        }
    }
}