package com.example.dashboard.presentation.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.core.base.base.BaseActivity
import com.example.core.base.navigation.feature.Dashboard.BUNDLE_TAB
import com.example.core.base.navigation.feature.MatchesHome
import com.example.core.base.navigation.feature.StatsHome
import com.example.dashboard.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseActivity() {

    override val layoutRes = R.layout.activity_dashboard

    override fun provideInitialFragment() = MatchesHome.dynamicStart

    override fun initActivity(savedInstanceState: Bundle?) {
        super.initActivity(savedInstanceState)

        bottomNavigation.setOnNavigationItemSelectedListener {
            val fragment: Fragment? = when (it.itemId) {
                R.id.navigation_matches -> {
                    MatchesHome.dynamicStart
                }
                R.id.navigation_stats -> {
                    StatsHome.dynamicStart
                }
                else -> {
                    MatchesHome.dynamicStart
                }
            }

            fragment?.let { frag ->
                supportFragmentManager.beginTransaction().replace(R.id.frameLayoutMain, frag)
                    .commit()
            }

            return@setOnNavigationItemSelectedListener true
        }


        if (savedInstanceState == null) {
            initTab(savedInstanceState)
        }
    }

    //LOOK AND CHECK WHY BUNDLE IS COMING???
    private fun initTab(bundle: Bundle?) {
        val tabId = bundle?.getString(BUNDLE_TAB)
        openScreen(tabId)
    }

    private fun openScreen(tabId: String?) {
        when (tabId) {
            MatchesHome.key -> {
                bottomNavigation.selectedItemId = R.id.navigation_matches
            }
        }
    }
}