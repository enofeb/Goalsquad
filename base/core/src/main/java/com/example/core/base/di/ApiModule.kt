package com.example.core.base.di

import com.example.core.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val GOAL_SQUAD_URL = "goal_squad_url"
private const val GOAL_SQUAD_CLIENT = "goal_squad_client"
const val GOAL_SQUAD_RETROFIT = "goal_squad_client"

val apiModule = module {
    factory(named(GOAL_SQUAD_URL)) {
        provideApiUrl()
    }

    single {
        provideLoggingInterceptor()
    }

    single(named(GOAL_SQUAD_CLIENT)) {
        provideOkHttpClient(loggingInterceptor = get())
    }

    single {
        provideGson()
    }

    single(named(GOAL_SQUAD_RETROFIT)) {
        provideRetrofit(
            baseUrl = get(named(GOAL_SQUAD_URL)),
            client = get(named(GOAL_SQUAD_CLIENT)),
            gson = get()
        )
    }
}

private fun provideApiUrl() = BuildConfig.BASE_URL

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor)
        addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.header("X-Auth-Token", BuildConfig.API_KEY)
            return@Interceptor chain.proceed(builder.build())
        })
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
    }
    return okHttpClientBuilder.build()
}

fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    return gsonBuilder.create()
}

fun provideRetrofit(baseUrl: String, client: OkHttpClient, gson: Gson): Retrofit =
    with(Retrofit.Builder()) {
        baseUrl(baseUrl)
        client(client)
        addConverterFactory(GsonConverterFactory.create(gson))
        build()
    }

