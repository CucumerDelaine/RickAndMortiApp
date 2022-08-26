package com.example.filmapps.app.di.components

import com.example.filmapps.app.di.module.*
import com.example.filmapps.app.presentation.ui.MainActivity
import com.example.filmapps.appApi.di.AppApi
import com.example.filmapps.appApi.di.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class, DatabaseModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface AppComponent: AppApi {

    fun inject(activity: MainActivity)
}