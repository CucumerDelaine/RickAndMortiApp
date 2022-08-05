package com.example.filmapps.domain.di.components

import com.example.filmapps.feature.regAndAuth.authorization.domain.di.module.AuthorizationModule
import com.example.filmapps.feature.regAndAuth.authorization.domain.di.scope.AuthorizationScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [AuthorizationModule::class], dependencies = [AppComponent::class])
@AuthorizationScope
interface AuthorizationComponent {
    fun viewModelsFactory(): ViewModelFactory
}