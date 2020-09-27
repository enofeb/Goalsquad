package com.example.matches.presentation.matches

import android.util.Log
import androidx.lifecycle.Observer
import com.example.core.base.model.DataHolder
import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchesHomeFragment : BaseFragment() {

    private val viewModel by viewModel<MatchesHomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_matches_home

    override fun observeData() {
        super.observeData()
        viewModel.matchListLiveData.observe(viewLifecycleOwner, Observer {
            if (it is DataHolder.Success) {
                Log.e("MATCHES", it.data.toString())
            }
        })
    }

    override fun fetchData() {
        super.fetchData()
        viewModel.getMatches()
    }

    companion object {
        fun newInstance() =
            MatchesHomeFragment()
    }
}