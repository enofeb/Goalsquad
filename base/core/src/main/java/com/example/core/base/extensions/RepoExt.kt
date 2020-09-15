package com.example.core.base.extensions

import com.example.core.base.base.Repo
import com.example.core.base.model.DataHolder
import java.lang.Exception


suspend fun <T : Any?> Repo.apiCall(
    apiCall: (suspend () -> T?)
): DataHolder<T?> {
    return try {
        DataHolder.Success(apiCall.invoke())
    } catch (e: Exception) {
        DataHolder.Fail(errorFactory.createApiError(e))
    }
}