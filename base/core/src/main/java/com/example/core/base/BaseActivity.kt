package com.example.core.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.R

open class BaseActivity : AppCompatActivity() {

    @IdRes
    open val containerId = R.id.frameLayoutMain

    @LayoutRes
    open val layoutRes = R.layout.activity_container

    open fun provideInitialFragment(): Fragment? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        provideInitialFragment()?.let {
            if (savedInstanceState == null) {
                //Extension
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(containerId, it)
                transaction.commit()
            }
        }
    }
}