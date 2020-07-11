package com.example.core.base.navigation.feature

import androidx.fragment.app.Fragment
import com.example.core.base.navigation.createFragmentFeature

object MatchesHome : Feature<Fragment> {

    private const val MATCHES_HOME = "com.example.matches.presentation.matches.MatchesHomeFragment"

    override val key: String
        get() = "1"
    override val dynamicStart: Fragment?
        get() = MATCHES_HOME.createFragmentFeature()
}