package com.example.filmapps.app.di.components

import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.module.RegistrationModule
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.scope.RegistrationScope
import dagger.Component

@Component(modules = [RegistrationModule::class], dependencies = [AppComponent::class])
@RegistrationScope
interface RegistrationComponent {
    fun viewModelsFactory(): ViewModelFactory
}
