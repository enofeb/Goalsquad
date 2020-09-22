package com.example.goalsquad.ui

import android.os.Bundle
import com.example.core.base.base.BaseActivity
import com.example.goalsquad.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    override val layoutRes = R.layout.activity_home

    override fun initActivity(savedInstanceState: Bundle?) {
        super.initActivity(savedInstanceState)
        navigationController.navigateToDashboard()
    }

}