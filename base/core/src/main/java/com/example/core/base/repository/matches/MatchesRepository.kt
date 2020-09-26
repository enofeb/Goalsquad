package com.example.core.base.repository.matches

import com.example.core.base.model.DataHolder
import com.example.core.base.model.matches.MatchesResponse
import kotlinx.coroutines.flow.Flow

interface MatchesRepository {
    suspend fun getMatches(): DataHolder<MatchesResponse?>
}