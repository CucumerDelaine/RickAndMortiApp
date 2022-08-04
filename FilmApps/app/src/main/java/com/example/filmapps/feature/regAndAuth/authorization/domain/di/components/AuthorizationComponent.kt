package com.example.filmapps.domain.di.components

import com.example.filmapps.feature.regAndAuth.authorization.domain.di.module.AuthorizationModule
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component
import javax.inject.Scope


@Component(modules = [AuthorizationModule::class], dependencies = [AppComponent::class])
@AuthorizationScope
interface AuthorizationComponent {

    fun viewModelsFactory(): ViewModelFactory
}

@Scope
annotation class AuthorizationScope