package com.example.goalsquad

import android.content.Intent
import android.os.Bundle
import com.example.core.base.base.BaseActivity
import com.example.dashboard.presentation.dashboard.DashboardActivity

class HomeActivity : BaseActivity() {

    override val layoutRes = R.layout.activity_home

    override fun initActivity(savedInstanceState: Bundle?) {
        super.initActivity(savedInstanceState)
        navigationController.navigateToDashboard()
    }

}