package com.example.core.base.repository.matches

import com.example.core.base.base.Repo
import com.example.core.base.services.MatchesServices

class MatchesRepositoryImpl(private val matchesServices: MatchesServices) : Repo(),
    MatchesRepository {
    override fun getMatches() {
        matchesServices.getMatches()
    }
}