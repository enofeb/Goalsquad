package com.example.core.base.navigation.controller

import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

interface NavigationController {

    val activity: WeakReference<FragmentActivity>

}