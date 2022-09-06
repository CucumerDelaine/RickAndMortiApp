package com.example.core.di

import android.content.Context
import com.example.core.data.NavigationScreens

object CoreComponentManager {

    lateinit var coreComponent: CoreAppApi

    fun getCore(context: Context, navigationScreens: NavigationScreens) {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(context))
            .navigationScreens(navigationScreens)
            .build()
    }
}
