package com.example.core.base.navigation.feature

import android.content.Intent
import com.example.core.base.navigation.createIntentFeature

object Dashboard : Feature<Intent> {

    private const val DASHBOARD = "com.example.dashboard.presentation.dashboard.DashboardActivity"

    override val key: String? = "tab"
    override val dynamicStart: Intent? = DASHBOARD.createIntentFeature()
}