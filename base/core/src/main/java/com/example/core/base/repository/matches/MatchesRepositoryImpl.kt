package com.example.core.base.repository.matches

import com.example.core.base.base.Repo
import com.example.core.base.extensions.apiCall
import com.example.core.base.model.DataHolder
import com.example.core.base.model.matches.MatchesResponse
import com.example.core.base.services.MatchesServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MatchesRepositoryImpl(private val matchesServices: MatchesServices) : Repo(),
    MatchesRepository {

    override suspend fun getMatches(): DataHolder<MatchesResponse?> {
        return apiCall {
            matchesServices.getMatches()
        }
    }

    override fun getMatchesFlow(): Flow<MatchesResponse?> = flow {
        emit(matchesServices.getMatches())
    }.map {
        it
    }
}