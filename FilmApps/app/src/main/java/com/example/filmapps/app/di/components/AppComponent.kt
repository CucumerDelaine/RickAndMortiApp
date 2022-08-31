package com.example.filmapps.app.di.components

import com.example.core.di.CoreAppApi
import com.example.filmapps.app.presentation.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [CoreAppApi::class])
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
}