package com.example.filmapps.di.components

import com.example.filmapps.di.module.CharacterDetailsNetwork
import com.example.filmapps.di.module.DetailsModule
import com.example.filmapps.di.scope.CharacterScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [DetailsModule::class, CharacterDetailsNetwork::class],
    dependencies = [AppComponent::class])
@CharacterScope
interface DetailsComponent {
    fun viewModelsFactory(): ViewModelFactory
}