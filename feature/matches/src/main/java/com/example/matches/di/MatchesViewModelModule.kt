package com.example.matches.di

import com.example.matches.presentation.MatchesHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val matchesViewModelModule = module {

    viewModel {
        MatchesHomeViewModel(matchesRepository = get())
    }

}