package com.example.stats.presentation

import com.example.core.com.example.core.base.base.BaseFragment
import com.example.stats.R

class StatsHomeFragment : BaseFragment() {

    override fun getLayoutRes() = R.layout.fragment_stats_home

    companion object {
        fun newInstance() = StatsHomeFragment()
    }
}