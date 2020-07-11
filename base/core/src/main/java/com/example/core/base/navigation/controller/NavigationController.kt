package com.example.core.base.navigation.controller

import androidx.fragment.app.FragmentActivity
import com.example.core.base.navigation.feature.Dashboard
import java.lang.ref.WeakReference

interface NavigationController {

    val activity: WeakReference<FragmentActivity>

    fun finish() = activity.get()?.finish()

    fun navigateToDashboard() = activity.get()?.startActivity(Dashboard.dynamicStart())

}