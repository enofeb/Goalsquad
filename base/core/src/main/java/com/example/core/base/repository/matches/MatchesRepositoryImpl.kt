package com.example.core.base.repository.matches

import com.example.core.base.base.Repo
import com.example.core.base.extensions.apiCall
import com.example.core.base.model.DataHolder
import com.example.core.base.model.matches.MatchesResponse
import com.example.core.base.services.MatchesServices

class MatchesRepositoryImpl(private val matchesServices: MatchesServices) : Repo(),
    MatchesRepository {

    override suspend fun getMatches(): DataHolder<MatchesResponse?> {
        return apiCall {
            matchesServices.getMatches()
        }
    }

}