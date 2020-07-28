package com.example.core.base.di

import com.example.core.BuildConfig
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


private fun provideApiUrl() = BuildConfig.BASE_URL

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder().apply {
        // addInterceptor(KeyInter) ADD INTERCEPTOR CLASS AND GO ON
        addInterceptor(loggingInterceptor)
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
    }
    return okHttpClientBuilder.build()
}

