package com.example.core.base.services

import com.example.core.base.model.matches.MatchesResponse
import retrofit2.http.GET

interface MatchesServices {
    @GET("matches")
    suspend fun getMatches(): MatchesResponse
}