package com.example.filmapps

import android.app.Application
import androidx.room.Room
import com.example.filmapps.data.AppDatabase
import com.example.filmapps.domain.di.components.AuthorizationComponent
import com.example.filmapps.domain.di.components.DaggerAuthorizationComponent
import com.example.filmapps.domain.di.module.ContextModule


class App : Application() {

    lateinit var app: AuthorizationComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        app = DaggerAuthorizationComponent
            .builder()
            .contextModule(ContextModule(context = this))
            .build()
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}