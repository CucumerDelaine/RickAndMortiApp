package com.example.filmapps.domain.di.components

import android.content.Context
import com.example.filmapps.domain.di.module.ContextModule
import com.example.filmapps.domain.di.module.NavigationModule
import com.example.filmapps.presentation.ui.AuthorizationFragment
import com.example.filmapps.presentation.ui.MainActivity
import com.example.filmapps.presentation.ui.RegistrationFragment
import com.github.terrakok.cicerone.Router
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, NavigationModule::class])
@Singleton
interface AppComponent {

    fun inject(fragment: RegistrationFragment)
    fun inject(activity: MainActivity)
    fun inject(fragment: AuthorizationFragment)

    fun getRouter() : Router
    fun getContext() : Context
}