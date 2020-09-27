package com.example.core.base.model.matches

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("id") val id: Int?,
    @SerializedName("homeTeam") val homeTeam: HomeTeam?,
    @SerializedName("awayTeam") val awayTeam: AwayTeam?
)