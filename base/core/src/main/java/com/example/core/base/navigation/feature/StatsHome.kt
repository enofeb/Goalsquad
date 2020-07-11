package com.example.core.base.navigation.feature

import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.core.base.navigation.createFragmentFeature

object StatsHome : Feature<Fragment> {

    private const val STATS_HOME = "com.example.stats.presentation.StatsHomeFragment"

    override val key: String?
        get() = "2"

    override val dynamicStart: Fragment?
        get() = STATS_HOME.createFragmentFeature()
}