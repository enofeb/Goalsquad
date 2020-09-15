package com.example.core.base.model.matches

import com.google.gson.annotations.SerializedName

data class MatchesResponse(
    @SerializedName("count") var count: Int?
)