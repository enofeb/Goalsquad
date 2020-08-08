package com.example.matches.presentation

import android.os.AsyncTask
import android.os.Bundle
import com.example.core.base.repository.matches.MatchesRepositoryImpl
import com.example.core.base.services.MatchesServices
import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R
import org.koin.android.ext.android.inject

class MatchesHomeFragment : BaseFragment() {

    override fun getLayoutRes() = R.layout.fragment_matches_home


    val service: MatchesServices by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doAsync {
            service.getMatches().execute()
        }.execute()
    }

    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }

    companion object {
        fun newInstance() =
            MatchesHomeFragment()
    }
}