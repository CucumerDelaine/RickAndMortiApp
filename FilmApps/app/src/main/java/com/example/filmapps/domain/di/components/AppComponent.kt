package com.example.filmapps.domain.di.components

import android.content.Context
import com.example.filmapps.data.bd.UserDataDAO
import com.example.filmapps.domain.di.module.ContextModule
import com.example.filmapps.domain.di.module.DatabaseModule
import com.example.filmapps.domain.di.module.NavigationModule
import com.example.filmapps.domain.di.module.NetworkModule
import com.example.filmapps.presentation.ui.MainActivity
import com.github.terrakok.cicerone.Router
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class, DatabaseModule::class, NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

    fun getRouter() : Router
    fun getContext() : Context
    fun getDatabase() : UserDataDAO
    fun getRetrofit(): Retrofit
}