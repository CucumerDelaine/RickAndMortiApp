package com.example.filmapps.domain.di.components

import com.example.filmapps.Presentation.Presenters.ViewModelFactory
import com.example.filmapps.domain.di.module.AuthorizationModule
import dagger.Component

@Component(modules = [AuthorizationModule::class])
public interface AuthorizationComponent {

    fun getViewModelFactory() : ViewModelFactory
}