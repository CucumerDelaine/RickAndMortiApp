package com.example.filmapps.app.presentation

import android.app.Application
import com.example.filmapps.ComponentManager
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.init(context = applicationContext)
    }
}