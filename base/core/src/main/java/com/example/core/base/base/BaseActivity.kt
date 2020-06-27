package com.example.core.base.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.R
import com.example.core.base.navigation.controller.DefaultNavigationController
import com.example.core.base.navigation.controller.NavigationController
import java.lang.ref.WeakReference

abstract class BaseActivity : AppCompatActivity() {

    @IdRes
    open val containerId = R.id.frameLayoutMain

    @LayoutRes
    open val layoutRes = R.layout.activity_container

    open fun provideInitialFragment(): Fragment? = null

    protected lateinit var navigationController: NavigationController

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationController = DefaultNavigationController(WeakReference(this))
        setContentView(layoutRes)

        provideInitialFragment()?.let {
            if (savedInstanceState == null) {
                //Extension
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(containerId, it)
                transaction.commit()
            }
        }
        initActivity(savedInstanceState)
    }

    open fun initActivity(savedInstanceState: Bundle?) {

    }
}