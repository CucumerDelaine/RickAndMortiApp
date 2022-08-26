package com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.components

import com.example.filmapps.app.di.components.AppComponent
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.module.DetailsModule
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.scope.DetailsScope
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [DetailsModule::class],
    dependencies = [AppComponent::class])
@DetailsScope
interface DetailsComponent {
    fun viewModelsFactory(): ViewModelFactory
}