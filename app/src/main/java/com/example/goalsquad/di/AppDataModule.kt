package com.example.goalsquad.di

import com.example.core.base.di.apiModule
import com.example.core.base.di.matchesDataModule

val appDataModule = listOf(
    apiModule, matchesDataModule
)