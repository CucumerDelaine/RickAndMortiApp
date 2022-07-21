package com.example.filmapps.domain.di.app

import android.app.Application
import com.example.filmapps.domain.di.module.AuthorizationModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application()