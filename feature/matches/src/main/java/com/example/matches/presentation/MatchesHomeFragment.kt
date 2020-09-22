package com.example.matches.presentation

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import com.example.core.base.repository.matches.MatchesRepository
import com.example.core.base.repository.matches.MatchesRepositoryImpl
import com.example.core.base.services.MatchesServices
import com.example.core.com.example.core.base.base.BaseFragment
import com.example.matches.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MatchesHomeFragment : BaseFragment() {

    override fun getLayoutRes() = R.layout.fragment_matches_home


    val matchesRepo: MatchesRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        doAsync {
//            service.getMatches().execute()
//        }.execute()


        CoroutineScope(Dispatchers.IO).launch {
            matchesRepo.getMatchesFlow().collect { value ->
                Log.e("HEY", value.toString())
            }
        }
    }

//    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
//        override fun doInBackground(vararg params: Void?): Void? {
//            handler()
//            return null
//        }
//    }


    companion object {
        fun newInstance() =
            MatchesHomeFragment()
    }
}