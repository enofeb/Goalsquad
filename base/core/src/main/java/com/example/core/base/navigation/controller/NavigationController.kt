package com.example.core.base.navigation.controller

import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

//KOTLIN INTERFACES NOTES
//It can't hold state of object unlike abstract class.
//Also they can't have fields and constructors unlike abstract class.
//It can have abstract fields and moreover,implementation of methods.
interface NavigationController {

    val activity: WeakReference<FragmentActivity>

    fun finish() = activity.get()?.finish()

}