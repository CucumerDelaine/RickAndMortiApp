package com.example.filmapps.domain.di.components

import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import com.example.filmapps.feature.regAndAuth.registrations.domain.di.module.RegistrationModule
import com.example.filmapps.feature.regAndAuth.registrations.domain.di.scope.RegistrationScope
import dagger.Component

@Component(modules = [RegistrationModule::class], dependencies = [AppComponent::class])
@RegistrationScope
interface RegistrationComponent {
    fun viewModelsFactory(): ViewModelFactory
}
