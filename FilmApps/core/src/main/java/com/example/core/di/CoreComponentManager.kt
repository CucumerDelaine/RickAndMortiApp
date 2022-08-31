package com.example.core.di

import android.content.Context

object CoreComponentManager {

    lateinit var coreComponent: CoreAppApi

    fun getCore(context: Context) {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(context))
            .build()
    }
}