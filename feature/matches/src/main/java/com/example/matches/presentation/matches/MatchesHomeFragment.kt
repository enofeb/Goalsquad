package com.example.matches.presentation.matches

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.base.model.DataHolder
import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R
import kotlinx.android.synthetic.main.fragment_matches_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchesHomeFragment : BaseFragment() {

    private val viewModel by viewModel<MatchesHomeViewModel>()

    private val matchListAdapter by lazy { MatchListAdapter() }

    override fun getLayoutRes() = R.layout.fragment_matches_home

    override fun initView() {
        super.initView()
        recyclerViewMatchList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = matchListAdapter
        }
    }


    override fun observeData() {
        super.observeData()
        viewModel.matchListLiveData.observe(viewLifecycleOwner, Observer {
            if (it is DataHolder.Success) {
                Log.e("MATCHES", it.data.toString())
                matchListAdapter.updateItems(it.data?.matchList?.toMutableList())
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