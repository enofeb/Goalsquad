package com.example.goalsquad.di

import com.example.core.base.di.apiModule
import com.example.core.base.di.matchesDataModule
import com.example.matches.di.matchesViewModelModule

val appDataModule = listOf(
    apiModule, matchesDataModule, matchesViewModelModule
)