package com.example.filmapps.domain.di.components

import com.example.filmapps.domain.di.module.*
import com.example.filmapps.domain.di.module.AuthorizationModule
import com.example.filmapps.presentation.ui.FirstFragment
import com.example.filmapps.presentation.ui.MainActivity
import com.example.filmapps.presentation.ui.SecondFragment
import com.example.filmapps.presentation.viewModel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AuthorizationModule::class, ViewModelModule::class, ContextModule::class, NavigationModule::class])
@Singleton
interface AuthorizationComponent {

    fun inject(fragment: FirstFragment)
    fun inject(activity: MainActivity)
    fun inject(fragment: SecondFragment)

    fun viewModelsFactory(): ViewModelFactory
}