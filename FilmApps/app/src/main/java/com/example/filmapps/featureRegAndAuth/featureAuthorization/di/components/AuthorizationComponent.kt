package com.example.filmapps.app.di.components

import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.module.AuthorizationModule
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.scope.AuthorizationScope
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [AuthorizationModule::class], dependencies = [AppComponent::class])
@AuthorizationScope
interface AuthorizationComponent {
    fun viewModelsFactory(): ViewModelFactory
}