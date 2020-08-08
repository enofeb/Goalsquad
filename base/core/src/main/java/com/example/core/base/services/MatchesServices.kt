package com.example.core.base.services

import com.example.core.base.model.matches.Matches
import retrofit2.Call
import retrofit2.http.GET

interface MatchesServices {
    @GET("matches")
    fun getMatches(): Call<Matches>
}