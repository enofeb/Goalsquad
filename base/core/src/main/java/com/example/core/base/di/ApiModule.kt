package com.example.core.base.di

import com.example.core.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor


private fun provideApiUrl()=BuildConfig.BASE_URL

fun provideLoggingInterceptor():HttpLoggingInterceptor=
    HttpLoggingInterceptor().apply { level=HttpLoggingInterceptor.Level.BODY }

