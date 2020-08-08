package com.example.core.base.di

import com.example.core.base.repository.matches.MatchesRepository
import com.example.core.base.repository.matches.MatchesRepositoryImpl
import com.example.core.base.services.MatchesServices
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val matchesDataModule = module {
    single {
        provideMatches(retrofit = get(named(GOAL_SQUAD_RETROFIT)))
    }
    single {
        provideMatchesRepository(matchesServices = get())
    }
}

private fun provideMatches(retrofit: Retrofit): MatchesServices =
    retrofit.create(MatchesServices::class.java)

private fun provideMatchesRepository(matchesServices: MatchesServices): MatchesRepository =
    MatchesRepositoryImpl(matchesServices = matchesServices)