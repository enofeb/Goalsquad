package com.example.matches.presentation

import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R

class MatchesHomeFragment : BaseFragment() {

    override fun getLayoutRes() = R.layout.fragment_matches_home

    companion object {
        fun newInstance() =
            MatchesHomeFragment()
    }
}