package com.example.filmapps.feature.characterListAndDetails.details.di.components

import com.example.filmapps.di.components.AppComponent
import com.example.filmapps.feature.characterListAndDetails.details.di.module.DetailsModule
import com.example.filmapps.feature.characterListAndDetails.details.di.scope.DetailsScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [DetailsModule::class],
    dependencies = [AppComponent::class])
@DetailsScope
interface DetailsComponent {
    fun viewModelsFactory(): ViewModelFactory
}