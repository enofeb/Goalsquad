package com.example.core.base.model.matches

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("fullTime") val fullTimeResult: FullTimeResult?
)