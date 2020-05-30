package com.example.core.base.navigation.controller

import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

class DefaultNavigationController(override val activity: WeakReference<FragmentActivity>) :
    NavigationController