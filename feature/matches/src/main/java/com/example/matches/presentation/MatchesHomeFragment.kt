package com.example.matches.presentation

import android.os.Bundle
import android.util.Log
import com.example.core.base.repository.matches.MatchesRepository
import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchesHomeFragment : BaseFragment() {

    private val viewModel by viewModel<MatchesHomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_matches_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() =
            MatchesHomeFragment()
    }
}