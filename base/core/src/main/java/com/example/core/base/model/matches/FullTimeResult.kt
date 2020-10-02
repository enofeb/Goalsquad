package com.example.core.base.model.matches

import com.google.gson.annotations.SerializedName

data class FullTimeResult(
    @SerializedName("homeTeam") val homeTeamFullScore: Int?,
    @SerializedName("awayTeam") val awayTeamFullScore: Int?
)