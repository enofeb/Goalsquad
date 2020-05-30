package com.example.goalsquad

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dashboard.presentation.dashboard.DashboardActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val i = Intent(this, DashboardActivity::class.java)
        startActivity(i)
    }
}