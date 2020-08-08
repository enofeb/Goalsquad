package com.example.goalsquad

import android.app.Application
import com.example.goalsquad.di.appDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GoalSquadApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val appModules = appDataModule
        startKoin {
            androidContext(this@GoalSquadApp)
            modules(modules = appModules)
        }
    }
}