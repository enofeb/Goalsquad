package com.example.core.base.repository.matches

import com.example.core.base.services.MatchesServices

class MatchesRepositoryImpl(private val matchesServices: MatchesServices) : MatchesRepository {
    override fun getMatches() {
        matchesServices.getMatches()
    }
}