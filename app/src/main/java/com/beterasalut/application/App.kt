package com.beterasalut.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.beterasalut.utils.SharedPreferencesUtils

class App : Application() {
    private var currentApplication: App? = null
    override fun onCreate() {
        super.onCreate()
        currentApplication = this
        SharedPreferencesUtils.init(applicationContext)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }

}